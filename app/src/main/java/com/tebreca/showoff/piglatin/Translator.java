package com.tebreca.showoff.piglatin;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * <a href='https://edabit.com/challenge/6dEDvruWbEDqXb7dk'>link to challenge</a>
 */
public class Translator {
    private static final String vowels = "aeoiuáéóíúàèùòìùäëöïüãõ";

    public static String translate(String s, String vowel) {
        if("".equals(s)){
            return "";
        }
        String[] split = s.split(vowel, 2);
        if(s.startsWith(vowel)){
            return s + "yay";
        }
        return vowel + split[1] + split[0] + "ay";
    }


    //TODO: keep proper punctuation and capitalisation in sentences
    public static String translate(String s) {
        if (!s.contains("\s")) {
            return translate(s.toLowerCase(), s.toLowerCase().chars().mapToObj(i -> String.valueOf((char) i)).filter(vowels::contains).findFirst().orElse("a"));
        } else {
            return Arrays.stream(s.split("\\s+")).map(Translator::translate).reduce((s1, s2) -> s1 + "\s" + s2).orElse("");
        }
    }
}
