package com.JSXExercise.reflection;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Cat {
    private String name = "招财猫";
    public int age = 10;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
        System.out.println("hi");
    }

    public void cry() {
        System.out.println(name + " 喵喵叫..");
    }
}
