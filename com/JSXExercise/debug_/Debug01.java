package com.JSXExercise.debug_;

public class Debug01 {
    public static void main(String[] args) {
        //逐行执行代码
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.print("i = " + i);
            System.out.print("sum = " + sum);
            System.out.println();
        }
        System.out.println("退出for....");
    }
}
