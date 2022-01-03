package com.tebreca.showoff.primeChecker;

import java.util.Arrays;

/**
 * <a href='https://www.codecademy.com/resources/blog/advanced-java-code-challenges'>link</a>
 */
public class PrimeChecker {

    private PrimeChecker(){

    }


    public static int[] findPrimes(int... numbers){
        return Arrays.stream(numbers).filter(PrimeChecker::isPrime).toArray();
    }

    /**
     * @param number the number to be checked
     * @return whether the given number is a prime
     */
    public static boolean isPrime(int number){
        if(Math.sqrt(number) %1 == 0){
            return false;
        }
        //not really the highest, but after we go up the pairs just reverse
        int highestDivisor = (int) Math.ceil(Math.sqrt(number));
        for (double i = 2; i < highestDivisor; i++){
            double solution = number / i;
            if(solution % 1 ==0){
                return false;
            }
        }
        return true;
    }
}
