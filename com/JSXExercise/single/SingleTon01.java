package com.JSXExercise.single;

public class SingleTon01 {
    public static void main(String[] args) {
        //通过方法可以获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance1);

        System.out.println(instance == instance1);
    }
}

//有一个GirlFriend类
//只能有一个女朋友
class GirlFriend {
    private String name;

    //为了能在静态方法中,返回gf对象,需要将其修饰为static
    private static GirlFriend gf = new GirlFriend("小红红");

    //单例模式【饿汉式】
    //1.将构造器私有化
    //2.在类的内部直接创建
    //3.提供一个公共的static方法,返回gf对象
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return gf;
    }
}