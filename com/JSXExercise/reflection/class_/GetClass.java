package com.JSXExercise.reflection.class_;

import com.JSXExercise.reflection.Car;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示得到Class对象的各种方式(6)
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName
        String classAllPath = "com.JSXExercise.reflection.Car"; //通过读取配置文件获取
        Class<?> cls = Class.forName(classAllPath);

        //2. 类名.class,应用场景：用于参数传递
        Class cls1 = Car.class;
        System.out.println(cls1);

        //3.对象.getClass(),应用场景,有对象实例
        Car car = new Car();
        Class cls2 = car.getClass();
        System.out.println(cls2);

        //4.通过类加载器[4种]来获取到类的Class对象
        //(1)先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls3 = classLoader.loadClass(classAllPath);
        System.out.println(cls3);

        //5.基本数据类型(int, char, boolean, float, double, byte, long, short) 按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);

        //基本数据类型对应的包装类,可以通过 .TYPE 得到Class类对象
        Class<Integer> type = Integer.TYPE;
    }
}
