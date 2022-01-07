package com.tebreca.showoff.piglatin;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href='https://edabit.com/challenge/6dEDvruWbEDqXb7dk'>link to challenge</a>
 */
public class Translator {

    public static String translate(String s, char vowel) {
        if("".equals(s)){
            return "";
        }
        String[] split = s.split(vowel + "", 1);
        if(split.length == 1){
            return s + "yay";
        }
        return vowel + split[1] + split[0] + "ay";
    }

    public static String translate(String s) {
        if (!s.contains("\s")) {
            return translate(s, s.chars().mapToObj(i -> (char) i).filter(c -> (c + "").matches("/[aeiou]/")).findFirst().orElse('a'));
        } else {
            return Arrays.stream(s.split("\\s+")).map(Translator::translate).reduce((s1, s2) -> s1 + "\s" + s2).orElse("");
        }
    }
}
