package com.jensen.driver;

import com.jensen.algorithms.Karatsuba;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by tjjensenjr on 3/4/15.
 */
public class driver {
    public static void main(String[] args) {
        Random rnd = new Random();
        final BigInteger x = new BigInteger(300, rnd);
        final BigInteger y = new BigInteger(300, rnd);

        final Karatsuba karatsuba = new Karatsuba();
        BigInteger result = new BigInteger("0");

        long startTime = 0;
        long endTime = 0;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            result = karatsuba.algorithm(x, y);
        }
        endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1000;

        System.out.println(executionTime);
        System.out.println(result);
        System.out.println(x.multiply(y));
    }
}
