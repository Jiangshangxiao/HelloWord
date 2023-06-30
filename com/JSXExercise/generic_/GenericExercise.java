package com.JSXExercise.generic_;

import java.util.*;

/**
 * @author 姜上晓
 * @version 1.0
 * 创建 3个学生对象 放入到HashSet中学生对象,
 * 使用. 放入到 HashMap中，要求 Key 是 String name,
 * Value 就是 学生对象 使用两种方式遍历
 */
@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        //使用泛型方式给HashSet放入三个学生对象
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 28));
        students.add(new Student("mary", 19));

        //遍历
        for (Student student : students) {
            System.out.println(student);
        }

        //使用泛型给HashMap放入三个学生对象
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put("milan", new Student("milan", 38));
        hashMap.put("smith", new Student("milan", 48));
        hashMap.put("hsp", new Student("milan", 28));

        //迭代器
        Set<Map.Entry<String, Student>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}