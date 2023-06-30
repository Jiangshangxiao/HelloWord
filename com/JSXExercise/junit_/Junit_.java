package com.JSXExercise.junit_;

import org.junit.jupiter.api.Test;

/**
 * @author 姜上晓
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Junit_ {
    public static void main(String[] args) {
        //传统方式
        //new Junit_().m1();
        //new Junit_().m2();
    }

    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }
}
