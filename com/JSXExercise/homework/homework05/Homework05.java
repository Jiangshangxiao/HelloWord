package com.JSXExercise.homework.homework05;

public class Homework05 {
    public static void main(String[] args) {
        Worker jack = new Worker("jack", 1000);
        jack.setSalMonth(15);
        jack.printSal();

        Peasant smith = new Peasant("smith", 20000);
        smith.printSal();

        Teacher teacher = new Teacher("JiangShangXiao", 2000);
        teacher.setClassDay(30);
        teacher.setClassSal(100);
        teacher.printSal();

        Scientist scientist = new Scientist("JiangShangZhao", 20000);
        scientist.setBonus(2000);
        scientist.printSal();
    }
}
