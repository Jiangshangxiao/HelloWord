package com.JSXExercise.bignum_;

import java.math.BigInteger;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class BigInteger_ {
    public static void main(String[] args) {
        BigInteger integer = new BigInteger("0192093102939219230122391");
        BigInteger integer1 = new BigInteger("123");

        BigInteger add = integer.add(integer1);
        System.out.println(add); //加

        BigInteger subtract = integer.subtract(integer1);
        System.out.println(subtract); //减

        BigInteger multiply = integer.multiply(integer1);
        System.out.println(multiply); //剩

    }
}
