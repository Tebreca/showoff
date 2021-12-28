package com.tebreca.showoff.wordbucket;

import java.util.*;

/**
 * <a href="https://edabit.com/challenge/3FAMXz4wAYGqpCtDR">link to challenge</a>
 */
public class Bucketer {

    private Bucketer() {

    }


    public static String bucketize(String s, int n) {
        String[] split = s.split(" ");
        Deque<String> words = new ArrayDeque<>(Arrays.asList(split));
        List<String> buckets = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (!words.isEmpty()) {
            String currentWord = words.pollFirst();
            if (builder.length() + currentWord.length() >= n) {
                buckets.add(builder.toString());
                builder = new StringBuilder().append(currentWord);
            } else {
                if (!builder.isEmpty()) {
                    builder.append(" ");
                }
                builder.append(currentWord);
            }
        }
        buckets.add(builder.toString());
        return Arrays.toString(buckets.toArray(new String[0]));

    }

}
