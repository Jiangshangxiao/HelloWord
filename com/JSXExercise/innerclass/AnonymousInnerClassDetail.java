package com.JSXExercise.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1() {

        Person p = new Person() {
            private int n1 = 88;
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi方法 n1 = " + n1);
                System.out.println("Outer05 n1 = " + Outer05.this.n1);
            }
        };
        p.hi(); //动态绑定,运行类型时Outer05$1

        //也可以直接调用
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi方法,haha...");
            }
        }.hi();
    }
}

class Person { //类
    public void hi() {
        System.out.println("Person hi()");
    }
}

//抽象类/接口