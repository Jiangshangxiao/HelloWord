package com.JSXExercise.homework.homework13;

/*
抽取一个父类Person类,将共同的属性和方法放到Person类
 */
public class Person {
    private String name;
    private char gender;
    private int age;

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return name + "爱玩";
    }

    //返回一个基本信息
    /*
    姓名: 张飞
    年龄: 30
    性别: 男
     */
    public String basicInfo() {
        return    "姓名: " + name + "\n"
                + "年龄: " + age + "\n"
                + "性别: " + gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
