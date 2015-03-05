package com.jensen.driver;


import java.math.BigInteger;
import java.util.Random;
/**
 * Created by tjjensenjr on 3/4/15.
 */
public class driver {
    public static void main(String[] args) {
        Random rnd = new Random();
        BigInteger bigInt = new BigInteger(300, rnd);

        System.out.println(bigInt.toString().length());
        System.out.println(bigInt.toString());
    }
}
