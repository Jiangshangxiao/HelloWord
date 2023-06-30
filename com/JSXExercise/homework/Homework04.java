package com.JSXExercise.homework;

public class Homework04 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 100, 20, 1.2);
        jack.setBonus(3000);
        jack.printSal();

        Worker tom = new Worker("tom", 50, 30, 1.0);
        tom.printSal();
    }
}
