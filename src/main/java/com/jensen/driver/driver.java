package com.jensen.driver;

import com.jensen.algorithms.Elementary;
import com.jensen.algorithms.Karatsuba;
import com.jensen.algorithms.Combined;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tjjensenjr on 3/4/15.
 */
public class driver {
    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        int bitSize = 1300;
        int repeatCount = 20;
        BigInteger bigRepeatCount = new BigInteger(Integer.toString(repeatCount));
        //BigInteger x = new BigInteger(bitSize, rnd);
        //BigInteger y = new BigInteger(bitSize, rnd);
        BigInteger karatsubaTime = new BigInteger("0");
        BigInteger elementaryTime = new BigInteger("0");
        BigInteger combinedTime = new BigInteger("0");
        ArrayList<Long> karatsubaList = new ArrayList<>();
        ArrayList<Long> elementaryList = new ArrayList<>();
        ArrayList<Long> combinedList = new ArrayList<>();
        BigInteger result = new BigInteger("0");
        BigInteger a = new BigInteger("10");
        Elementary elementary = new Elementary();
        Karatsuba karatsuba = new Karatsuba();
        Combined combined = new Combined();



        long executionTime = 0;
        long startTime = 0;
        long endTime = 0;
        //BigInteger n;

        for (int j = 0; j < repeatCount; j++) {
            BigInteger x = new BigInteger(bitSize, rnd);
            BigInteger y = new BigInteger(bitSize, rnd);

            startTime = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                result = combined.algorithm(x, y);
            }
            endTime = System.nanoTime();
            if (!x.multiply(y).equals(result)) {
                throw new Exception("Algorithm did not compute multiplication correctly");
            }
            executionTime = (endTime - startTime) / 10;
            combinedList.add(executionTime);


            startTime = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                BigInteger am = new BigInteger(elementary.multiply(x.toString(), y.toString()));
                //x.multiply(y);
            }
            endTime = System.nanoTime();

            executionTime = (endTime - startTime) / 10;
            elementaryList.add(executionTime);


            startTime = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                result = karatsuba.algorithm(x, y);
            }
            endTime = System.nanoTime();

            executionTime = (endTime - startTime) / 10;
            karatsubaList.add(executionTime);
        }

        for (Long time: karatsubaList) {
            BigInteger t = new BigInteger(time.toString());
            karatsubaTime = karatsubaTime.add(t);
            //System.out.println(t);
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (Long time: elementaryList) {
            BigInteger t = new BigInteger(time.toString());
            elementaryTime = elementaryTime.add(t);
           // System.out.println(t);
        }

        for (Long time: combinedList) {
            BigInteger t = new BigInteger(time.toString());
            combinedTime = combinedTime.add(t);
            // System.out.println(t);
        }

        System.out.println("Elementry "+ elementaryTime.divide(bigRepeatCount));
        System.out.println("Karatsuba " +karatsubaTime.divide(bigRepeatCount));
        System.out.println("Combinedt " +combinedTime.divide(bigRepeatCount));



        for (int j = 0; j < 1000; j++){
            BigInteger x=new BigInteger(bitSize,rnd);
            BigInteger y=new BigInteger(bitSize,rnd);

            startTime=System.nanoTime();
            for(int i=0;i<10;i++){
                result = karatsuba.algorithm(x,y);
            }
            endTime=System.nanoTime();
            if(!x.multiply(y).equals(result)){
                throw new Exception("Algorithm did not compute multiplication correctly");
            }
            executionTime=(endTime-startTime)/10;
            combinedList.add(executionTime);
        }

        for (Long time: karatsubaList) {
            BigInteger t = new BigInteger(time.toString());
            karatsubaTime = karatsubaTime.add(t);
        }

        System.out.println("Karatsuba Execution Time = " + karatsubaTime.divide(new BigInteger("1000")));

        System.out.println("Does this work");
    }
}


