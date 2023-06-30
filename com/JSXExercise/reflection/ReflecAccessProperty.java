package com.JSXExercise.reflection;

import java.lang.reflect.Field;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示反射操作属性
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1.得到Student类对应地Class对象
        Class<?> stuClass = Class.forName("com.JSXExercise.reflection.Student");
        //2. 创建对象
        Object o = stuClass.newInstance(); // 0 的运行类型就是Student
        System.out.println(o.getClass());
        //3.使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);
        System.out.println(o);
        System.out.println(age.get(o));

        //4.使用反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        //对name进行爆破, 可以操作private 属性
        name.setAccessible(true);
        name.set(null, "Jiang");
        System.out.println(o);
    }
}

class Student {
    public int age;
    private static String name = null;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                "name=" + name +
                '}';
    }
}
