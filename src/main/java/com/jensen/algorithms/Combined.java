package com.jensen.algorithms;

import java.math.BigInteger;

/**
 * Created by tjjensenjr on 3/12/15.
 */
public class Combined {

    static Elementary elementary = new Elementary();

    public static BigInteger algorithm(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 690) return new BigInteger(elementary.multiply(x.toString(),y.toString()));


        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = Combined.algorithm(a, c);
        BigInteger bd = Combined.algorithm(b, d);
        BigInteger abcd = Combined.algorithm(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }
}
