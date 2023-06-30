package com.JSXExercise.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        /**
         * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
         * 提供getName的公有方法
         * 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值
         */
        //1.得到privateTest类对应的Class对象
        Class<PrivateTest> privateTestClass = PrivateTest.class;
        //2.创建对象实例
        PrivateTest privateTest = privateTestClass.newInstance();
        //3.得到name属性
        Field name = privateTestClass.getDeclaredField("name");
        //4.爆破name
        name.setAccessible(true);
        name.set(privateTest, "Jiang");
        //5.得到getName方法对象
        Method getName = privateTestClass.getMethod("getName");
        //6.因为getName()是public,所有直接调用
        Object invoke = getName.invoke(privateTest);
        System.out.println("name属性值 = " + invoke);
    }
}

class PrivateTest {
    private String name = "hellokitty";



    public String getName() {
        return name;
    }
}
