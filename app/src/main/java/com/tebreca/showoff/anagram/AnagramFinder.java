package com.tebreca.showoff.anagram;

import java.util.*;

/**
 * <a href='https://edabit.com/challenge/gvfWZYpmkAu99TKWt'>link to challenge</a>
 */
public class AnagramFinder {

    private static Optional<String> findAnagram(String text, String anagram, int anchor, char anchored) {
        char key = anagram.charAt(0);
        List<Character> characters = new ArrayList<>();
        anagram.substring(1).chars().mapToObj(i -> (char) i).forEach(characters::add);
        StringBuilder solution = new StringBuilder().append(anchored);
        int currentIndex = anchor;
        //ive used 3 variants of this already :o
        while (!characters.isEmpty()) {
            currentIndex--;
            if (currentIndex < 0)
                break;
            char current = text.charAt(currentIndex);
            if (characters.contains(current)) {
                characters.remove((Character) current);
                solution.insert(0, current);
            } else {
                break;
            }
        }
        currentIndex = anchor;
        while (!characters.isEmpty()) {
            currentIndex++;
            if (currentIndex > text.length())
                break;
            char current = text.charAt(currentIndex);
            if (characters.contains(current)) {
                characters.remove((Character) current);
                solution.append(current);
            } else {
                break;
            }
        }
        if(characters.isEmpty()) {
            return Optional.of(solution.toString());
        }
        return Optional.empty();
    }

    public static Optional<String> findAnagram(String text, String anagram){
        text = text.replaceAll("[^A-Za-z]+", "").toLowerCase(Locale.ROOT);
        anagram = anagram.replaceAll("[^A-Za-z]+", "").toLowerCase(Locale.ROOT);
        char c = anagram.charAt(0);
        List<Optional<String>> results = new ArrayList<>();
        for (int index = text.indexOf(c);
             index >= 0;
             index = text.indexOf(c, index + 1))
        {
            results.add(findAnagram(text, anagram, index, c));
        }
        return results.stream().filter(Optional::isPresent).findAny().orElse(Optional.empty());
    }


}
