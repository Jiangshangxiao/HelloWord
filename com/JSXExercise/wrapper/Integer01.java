package com.JSXExercise.wrapper;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Integer01 {
    public static void main(String[] args) {
        //jdk5前手动装箱和拆箱
        int n1 = 100;
        Integer integer = Integer.valueOf(n1);

        //手动拆箱
        int i = integer.intValue();

        //jdk5后,就可以自动装箱和自动拆箱
        int n2 = 200;
        //自动装箱 int -> Integer
        Integer integer1 = n2;
        //自动拆箱 Integer -> int
        int n3 = integer1;
    }
}
