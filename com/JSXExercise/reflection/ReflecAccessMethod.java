package com.JSXExercise.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.得到Boss类对应的Class对象
        Class<?> bossCls = Class.forName("com.JSXExercise.reflection.Boss");
        //2. 创建对象
        Object o = bossCls.newInstance();
        //3. 调用public的hi方法
        //Method hi = bossCls.getMethod("hi");
        //3.1 得到hi方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);
        //3.2 调用
        hi.invoke(o, "Jiang");

        //4. 调用private static 方法
        //4.1 得到say方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2 因为say方法是private, 所以需要爆破
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));

        //5. 在反射中,如果方法有返回值, 统一返回Object
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型 = " + reVal.getClass()); //String
    }
}

class Boss {
    public int age;
    private static String name;
    public Boss() {

    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi" + s);
    }
}