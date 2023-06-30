package com.JSXExercise.homework;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework15 {
    public static void main(String[] args) {
        new A().f1();
    }
}
/*
编写一个类,在类中定义局部内部类B,B中有一个私有final常量name,有一个方法show()
打印常量name.进行测试
 */
class A {
    private String name = "hello";
    public void f1() {
        class B {
            private final String name = "JiangShangXiao";
            public void show() {
                System.out.println("B name = " + name + " A name = " + A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}