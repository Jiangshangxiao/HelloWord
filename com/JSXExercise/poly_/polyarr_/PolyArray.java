package com.JSXExercise.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {
        //应用实例:现有一个继承结构如下:要求创建1个Person对象
        //2个Student对象和2个Teacher对象,统一放在数组中,并调用每个对象say方法

        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("jack", 18, 100);
        persons[2] = new Student("smith", 19, 30.1);
        persons[3] = new Teacher("scott", 30, 20000);
        persons[4] = new Teacher("king", 50, 25000);

        //循环遍历多态数组,调用say
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());;
            if (persons[i] instanceof Student) {
                ((Student)persons[i]).study();
            } else if (persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();
            } else {
                System.out.println("你的类型有误,请自己检查....");
            }
        }
    }
}
