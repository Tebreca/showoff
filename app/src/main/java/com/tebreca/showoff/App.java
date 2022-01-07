/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.tebreca.showoff;

import com.tebreca.showoff.anagram.AnagramFinder;
import com.tebreca.showoff.encryptor.Encrypt;
import com.tebreca.showoff.hash.Hasher;
import com.tebreca.showoff.lambdaChallenge.LambdaSupplier;
import com.tebreca.showoff.primeChecker.PrimeChecker;
import com.tebreca.showoff.wordbucket.Bucketer;
import com.tebreca.showoff.wordconnector.WordConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class App {

    public static void main(String[] args) {
        System.out.println(Encrypt.encrypt("chill out"));
        System.out.println(Bucketer.bucketize("the mouse jumped over a cheese wheel", 13));
        System.out.println(Arrays.toString(PrimeChecker.findPrimes(3,4,5,6,8,9,10,234,23422,7,69,7993, 999999937 )));
        System.out.println(LambdaSupplier.getOddChecker().apply(23));
        System.out.println(LambdaSupplier.getOddChecker().apply(22));
        Function<Integer, Boolean> palindromeChecker = LambdaSupplier.getPalindromeChecker();
        System.out.println(palindromeChecker.apply(18981));
        System.out.println(palindromeChecker.apply(18983));
        List<Integer> palindromeNumbers = new ArrayList<>();
        for(int i  =0 ; i < 100000; i++){
            if(palindromeChecker.apply(i)){
                palindromeNumbers.add(i);
            }
        }
        System.out.println(Arrays.toString(palindromeNumbers.toArray()));
        System.out.println(Hasher.hashSha256("AVEryStrongPassword2"));

        System.out.println(AnagramFinder.findAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(AnagramFinder.findAnagram("An old west action hero actor", "Clint Eastwood"));

        System.out.println(WordConnector.join("oven", "envier", "erase", "serious"));
    }





}
