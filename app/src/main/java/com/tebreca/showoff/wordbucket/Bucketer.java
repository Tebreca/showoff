package com.tebreca.showoff.wordbucket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://edabit.com/challenge/3FAMXz4wAYGqpCtDR">link to challenge</a>
 */
public class Bucketer {

    public static String bucketize(String s, int n){
        Stack<String> words = new Stack<>();
        Arrays.stream(s.split(" ")).forEach(words::add);
        List<String> buckets = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (!words.empty()){
            String currentWord = words.pop();
            if(builder.length() + currentWord.length() > n){
                buckets.add(builder.toString());
                builder = new StringBuilder().append(currentWord);
            } else {
                builder.append('\n').append(currentWord);
            }
        }

        return Arrays.toString(buckets.toArray(new String[0]));

    }

}
