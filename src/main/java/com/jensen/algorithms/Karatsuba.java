package com.jensen.algorithms;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by tjjensenjr on 3/4/15.
 */
public class Karatsuba {
    Random rnd = new Random();
    BigInteger bigInt = new BigInteger(300, rnd);

    public static BigInteger algorithm(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());

        if (N <= 1) return x.multiply(y);

        N = (N/2) + (N%2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = Karatsuba.algorithm(a, c);
        BigInteger bd = Karatsuba.algorithm(b, d);
        BigInteger abcd = Karatsuba.algorithm(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }
}
