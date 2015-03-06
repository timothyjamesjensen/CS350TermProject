package com.jensen.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tjjensenjr on 3/4/15.
 */
public class Elementary {

    public static BigInteger algorithm(BigInteger x, BigInteger y) {
        int xLength = x.toString().length();
        int yLength = y.toString().length();
        int xCount = xLength - 1;
        int yCount = yLength - 1;
        int j = 0;
        int carry = 0;
        int digit = 0;
        int[] partial = new int[12];
       // BigInteger result = new BigInteger("0");
        BigInteger temp = new BigInteger("0");
        for (int i = 0; i < xLength; i++) {
            carry = 0;
            yCount = yLength - 1;
            for (j = 0; j < yLength; j ++) {
                digit = (partial[j] + Character.getNumericValue(x.toString().charAt(yCount))
                        * Character.getNumericValue(y.toString().charAt(xCount)) + carry);
                carry = (digit / 10);
                partial[j] = digit % 10;
                yCount--;
             }
            if (carry != 0) {
                digit = partial[j] + carry;
                carry = (digit / 10);
                partial[j] = digit % 10;
            }
            xCount--;
        }
        System.out.println(Arrays.toString(partial));
        for (int i = 0; i < 2; i++){}
        //BigInteger result = new BigInteger(Arrays.toString(partial));
        return x;
    }
    public String multiply(String str1, String str2) {
        int length = str1.length()<str2.length()?str1.length():str2.length();
        int num1 = 0, carry = 0, multiply = 0, i = 0, temp = 0, count = 0;
        String smallString = "", largeString = "", result1 = "", result2 = "", sum = "";
        if(length == str1.length()) {
            smallString = str1;
            largeString = str2;
        }
        else {
            smallString = str2;
            largeString = str1;
        }

        for(i = length - 1; i >= 0; i--) {
            num1 = smallString.charAt(i)-'0';
            count++;
            if(length==1&&num1==0) {
                return "0";
            }
            for(int j= largeString.length() - 1; j >= 0; j--) {
                multiply = (num1*(largeString.charAt(j)-'0'));
                temp = multiply + carry;
                multiply = (multiply + carry) % 10;
                sum = multiply + sum;
                result1 = sum + result1;
                carry = temp / 10;
                sum="";
            }
            if (carry >= 1) {
                result1 = carry + result1;
            }
            carry=0;
            for (int index = count; index > 1; index--) {
                result1 = result1 + 0;
            }
            result2 = add(result2,result1);//calling add(str1,str2) for adding numbers
            result1 = "";
        }
        return result2;
    }
    public String add(String str1, String str2){
        int length = str1.length()>str2.length()?str1.length():str2.length();
        int carry = 0;
        int length1 = str1.length();
        int length2 = str2.length();
        if(length1 == 0) {
            return str2;
        }
        if(length2 == 0) {
            return str1;
        }
        int addition = 0;
        String result = "";
        int num1 = str1.charAt(length1-1)-'0';
        int num2 = str2.charAt(length2-1)-'0';
        addition = num1 + num2;

        if(addition > 9) {
            carry = 1;
            addition = addition % 10;
        }
        else {
            carry = 0;
        }
        result = addition + result;
        addition=0;
        --length1; --length2;
        for(int i = length - 2; i >= 0; i--) {
            if(length1 > 0)
            {
                num1=str1.charAt(length1-1)-'0';
                length1--;
            }
            else
                num1=0;
            if(length2>0) {
                num2 = str2.charAt(length2 - 1)-'0';
                length2--;
            }
            else {
                num2 = 0;
            }
            addition = num1 + num2 + carry;
            if(addition > 9) {
                carry = 1;
                addition = addition % 10;
            }
            else {
                carry = 0;
            }
            result = addition + result;
            addition = 0;
        }
        if(carry == 1) {
            return 1 + result;
        }
        return result;
    }

}
