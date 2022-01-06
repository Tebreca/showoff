package com.tebreca.showoff.wordconnector;

import java.util.Arrays;

/**
 * <a href='https://edabit.com/challenge/zZCARMRzJ2sHLbgwe'>link to challenge</a>
 */
public class WordConnector {

    private WordConnector() {

    }

    public static String join(String... words) {
        return Arrays.stream(words).reduce((s, s2) -> s + s2.substring(Math.max(s2.indexOf(s.charAt(s.length() - 1)) + 1, 0))).orElse(String.join("", words));
    }

}
