package com.JSXExercise.static_;

public class StaticMethod {
    public static void main(String[] args) {
        //创建两个学生对象,交学费
        Stu stu = new Stu("tom");
        //stu.payFee(100);
        Stu.payFee(100);

        Stu mary = new Stu("mary");
        //mary.payFee(100);
        Stu.payFee(200);

        //输出当前收到的总学费
        Stu.showFee();
    }
}

class Stu {
    private String name; //普通成员
    //定义一个静态变量,来累计学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void showFee() {
        System.out.println("总学费有: " + Stu.fee);
    }
}