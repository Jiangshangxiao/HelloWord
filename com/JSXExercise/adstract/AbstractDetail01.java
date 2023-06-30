package com.JSXExercise.adstract;

public class AbstractDetail01 {
    public static void main(String[] args) {
        //抽象类不能别实例化
        //new A();
    }
}

//抽象类可以没有抽象方法
//还可以有实现方法
abstract class A {
    public void hi() {
        System.out.println("hi");
    }
}
