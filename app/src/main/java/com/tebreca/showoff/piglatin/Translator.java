package com.tebreca.showoff.piglatin;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a href='https://edabit.com/challenge/6dEDvruWbEDqXb7dk'>link to challenge</a>
 */
public class Translator {
    private static final String vowels = "aeoiuáéóíúàèùòìùäëöïüãõ";

    public static String translate(String s, String vowel) {
        if(s.length() <= 0){
            return "";
        }
        PunctuationProfile profile = PunctuationProfile.createFromWord(s);
        s = s.replaceAll("\\p{IsPunctuation}", "");
        String[] split = s.split(vowel, 2);
        if(s.startsWith(vowel)){
            return s + "yay";
        }
        String stripped = vowel + split[1] + split[0] + "ay";
        return profile.apply(stripped);
    }

    public static String translate(String s) {
        if(s.length() <1){
            return s;
        }

        if (!s.contains("\s")) {
            boolean flag = Character.isUpperCase(s.charAt(0));
            String translate = translate(s.toLowerCase(), s.toLowerCase().chars().mapToObj(i -> String.valueOf((char) i)).filter(vowels::contains).findFirst().orElse("a"));
            return flag ? capitalize(translate) : translate;
        } else {
            return Arrays.stream(s.split("\\s+")).map(Translator::translate).collect(Collectors.joining("\s"));
        }
    }

    private static String capitalize(String translate) {
        return Character.toUpperCase(translate.charAt(0)) + translate.substring(1);
    }

    public static class PunctuationProfile{

        public enum Position{
            FRONT, BACK;

            //just moving all punctuation from the middle of words too, as the challenge does not specify anything about it, and this keeps the code tidier
            public static Position getFromIndex(int index, int length){
                if(index > Math.sqrt(length)){
                    return BACK;
                }
                return FRONT;
            }
        }

        List<Map.Entry<String, Position>> puctuationEntries = new ArrayList<>();

        private PunctuationProfile(List<Map.Entry<String, Position>> entries){
            puctuationEntries.addAll(entries);
        }

        public static PunctuationProfile createFromWord(String word){
            return new PunctuationProfile(word.chars().mapToObj(i->String.valueOf((char)i)).filter(c-> Pattern.matches("\\p{IsPunctuation}", c))//
                    .map(s ->(Map.Entry<String, Position>) new AbstractMap.SimpleEntry<>(s, Position.getFromIndex(word.indexOf(s), word.length()))).toList());
        }

        public String apply(String stripped){
            StringBuilder builder = new StringBuilder(stripped);
            puctuationEntries.forEach(entry->{
                switch (entry.getValue()){
                    case FRONT -> builder.insert(0, entry.getKey());
                    case BACK -> builder.append(entry.getKey());
                }
            });
            return builder.toString();
        }


    }

}
