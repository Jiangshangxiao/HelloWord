package com.JSXExercise.main_;

public class Main01 {
    //静态变量
    private static String name = "JiangShang";

    public static void hi() {
        System.out.println("Main01的hi方法");
    }

    public static void main(String[] args) {

        //可以直接使用name
        System.out.println("name = " + name);
        hi();
    }
}
