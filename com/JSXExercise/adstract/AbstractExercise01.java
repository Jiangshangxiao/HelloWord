package com.JSXExercise.adstract;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 999, 2000);
        jack.setBonus(8000);
        jack.work();

        CommonEmployee tom = new CommonEmployee("tom", 888, 1000);
        tom.work();
    }
}
