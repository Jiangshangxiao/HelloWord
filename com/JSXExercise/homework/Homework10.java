package com.JSXExercise.homework;

public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("jack", 20, "牙科医生", '男', 2000);
        Doctor doctor1 = new Doctor("jack", 20, "牙科医生", '男', 2000);

        System.out.println(doctor1.equals(doctor));
    }
}
