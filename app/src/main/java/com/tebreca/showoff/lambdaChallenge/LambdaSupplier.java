package com.tebreca.showoff.lambdaChallenge;

import com.tebreca.showoff.primeChecker.PrimeChecker;

import java.util.function.Function;

/**
 * though i did change it up a bit cause
 * <a href='https://www.hackerrank.com/challenges/java-lambda-expressions/problem'>link to challenge</a>
 */
public class LambdaSupplier {

    public static Function<Integer, Boolean> getPrimeChecker() {
        return PrimeChecker::isPrime;
    }

    public static Function<Integer, Boolean> getOddChecker() {
        return i -> i % 2 == 1;
    }

    public static Function<Integer, Boolean> getPalindromeChecker() {
        return i->{
            String number = Integer.toString(i);
            return new StringBuffer(number).reverse().toString().equals(number);
        };
    }
}
