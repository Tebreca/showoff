package com.tebreca.showoff.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <a href='https://www.hackerrank.com/challenges/sha-256/problem'>link t challenge</a>
 */
public class Hasher {

    public static String hashSha256(String raw){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return new BigInteger(md.digest(raw.getBytes())).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return raw;
    }

}
