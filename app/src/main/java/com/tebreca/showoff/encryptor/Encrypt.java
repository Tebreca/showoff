package com.tebreca.showoff.encryptor;

import java.util.Arrays;

/**
 * <a href='https://edabit.com/challenge/jfCsugyp9BSLYEtwb'>link to challenge</a>
 */
public class Encrypt {

    private Encrypt(){

    }

    public static String encrypt(String s) {
        s = s.replace("\s", "");
        double root = Math.sqrt(s.length());
        int width = (int) Math.ceil(root);
        int height = (int) Math.floor(root);
        if(width * height < s.length()){
            height++;
        }
        int index = 0;
        char[][] table = new char[width][height];
        for (int currentHeight = 0; currentHeight < height; currentHeight++)
            for (int currentWidth = 0; currentWidth < width; currentWidth++) {
                if (index < s.length()) {
                    table[currentWidth][currentHeight] = s.charAt(index);
                }
                index++;
            }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(table).forEach((chars) -> {
            builder.append(' ').append(chars);
        });
        return builder.toString().substring(1).trim();
    }


}
