package com.JSXExercise.innerclass;

/**
 * 演示匿名内部类的使用
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer02 = new Outer04();
        outer02.method();
    }
}

class Outer04 {
    private int n1 = 10;
    public void method() {
        A tiger = new A() {

            @Override
            public void cry() {
                System.out.println("老虎叫唤....");
            }
        };
        tiger.cry();

        Father father = new Father() {
            @Override
            public void test() {
                System.out.println("匿名内部类实现了test方法");
            }
        };
        father.test();


    }
}

interface A {
    void cry();
}

class Father {
    public Father() {
    }

    public void test() {

    }
}