package com.jensen.driver;

import com.jensen.algorithms.Elementary;
import com.jensen.algorithms.Karatsuba;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by tjjensenjr on 3/4/15.
 */
public class driver {
    public static void main(String[] args) {
        Random rnd = new Random();
        int bitSize = 10;
        final BigInteger x = new BigInteger(bitSize, rnd);
        final BigInteger y = new BigInteger(bitSize, rnd);
        BigInteger result = new BigInteger("0");
        BigInteger a = new BigInteger("10");
        Elementary elementary = new Elementary();

        final Karatsuba karatsuba = new Karatsuba();

        long executionTime = 0;
        long startTime = 0;
        long endTime = 0;

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            BigInteger n = new BigInteger(elementary.multiply(x.toString(), y.toString()));
        }
        endTime = System.nanoTime();

        executionTime = (endTime - startTime) / 100;
        System.out.println(executionTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            result = karatsuba.algorithm(x, y);
        }
        endTime = System.nanoTime();

        executionTime = (endTime - startTime) / 100;
        System.out.println(executionTime);
    }
}
