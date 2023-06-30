package com.JSXExercise.extend;

//编写Computer类,包含CPU、内存、硬盘等属性,getDetails方法用于返回Computer的详细信息
public class ExtendExercise {
    public static void main(String[] args) {
        PC pc = new PC("intel", 16, 500, "IBM");
        pc.printInfo();
    }
}
