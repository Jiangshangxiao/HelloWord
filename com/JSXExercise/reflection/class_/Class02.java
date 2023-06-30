package com.JSXExercise.reflection.class_;

import com.JSXExercise.reflection.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示Class类得常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.JSXExercise.reflection.Car";
        //1.获取到Car类 对应的Class对象
        Class<?> cls = Class.forName(classAllPath);
        //2.输出cls
        System.out.println(cls); //显示cls对象,是哪个类的Class对象 com.JSXExercise.reflection.Car
        System.out.println(cls.getClass()); //输出cls运行类型 java.lang.Class
        //3.得到包名
        System.out.println(cls.getPackage().getName());
        //4.得到类名
        System.out.println(cls.getName());
        //5.通过cls创建对象实例
        Car car = (Car) cls.getDeclaredConstructor().newInstance();
        System.out.println(car);
        //6.通过放射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        //7.通过放射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));
        //8.得到所有的属性
        System.out.println("==========所有字段类型=========");
        Field[] fields = cls.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());
            System.out.println(f.get(car));
        }
    }
}
