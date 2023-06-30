package com.JSXExercise.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示通过反射机制创建实例
 */
public class ReflecCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.先获取到User类地Class对象
        Class<?> userClass = Class.forName("com.JSXExercise.reflection.User");
        //2。通过public地无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3.通过public地有参构造器创建实例
        Object o1 = userClass.getConstructor(String.class).newInstance("hi");
        System.out.println(o1);
        //4.通过非public地有参构造器创建实例
        //setAccessible 爆破【暴力破解】 , 使用反射可以访问private构造器/方法/属性
        Constructor<?> constructor = userClass.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        Object jiang = constructor.newInstance(20, "jiang");
        System.out.println(jiang);
    }
}

class User {
    private int age = 10;
    private String name = "Jiang";
    public User() {

    }

    public User(String name) {
        this.name = name;
    }
    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
