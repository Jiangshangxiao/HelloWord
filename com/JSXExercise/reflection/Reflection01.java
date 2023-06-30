package com.JSXExercise.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Reflection01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //1. 使用Properties类,可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("methodName").toString();

        //使用发射机制加载类,返回Class类型得对象cls
        Class cls = Class.forName(classfullpath);
        //通过cls得到加载类com.JSXExercise.reflection.Cat得对象实例
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println("o得运行类型 = " + o.getClass());
        //通过cls得到加载的类comJSXExercise.reflection.Cat得hi得方法对象
        // 再反射中,可以把方法视为对象
        Method method = cls.getMethod(methodName);
        //同故宫method调用方法: 通过方法对象来实现调用方法
        System.out.println("======================");
        method.invoke(o); //传统方法 对象.方法() , 放射机制 方法.invoke(对象)

        //java.lang.reflect.Field: 代表类得成员变量,Field对象表示某个类得成员变量
        //得到name字段
        //getField不能得到私有的变量
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));

        //java.lang.reflect.Constructor: 代表类得构造方法,Constructor对象表示构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor); //Cat()

        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1); //Cat(String)
    }

}
