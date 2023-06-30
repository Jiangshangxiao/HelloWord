package com.JSXExercise.object;

public class EqualsExercise {
    public static void main(String[] args) {
        Person person1 = new Person("jack", 10, '男');
        Person person2 = new Person("smith", 10, '男');
        System.out.println(person1.equals(person2));
    }
}
class Person{
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public boolean equals(Object obj) {
        //判断如果比较的两个对象时同一个对象,则直接返回true
        if (this == obj) {
            return true;
        }
        //类型判断
        if(obj instanceof  Person) { //是person,才比较
            //进行向下转型,需要得到obj的各个属性
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        //如果不是Person,则直接返回false
        return false;
    }
}
