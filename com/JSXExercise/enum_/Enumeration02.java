package com.JSXExercise.enum_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
    }
}

//演示定义枚举实现
enum Season { //类

    SPRING("春天","温暖"),WINTER("冬天","寒冷"),
    AUTUMN("秋天","凉爽"),SUMMER("夏天","炎热");
    private String name;
    private String desc; //描述

    //定义四个对象
//    public static final Season SPRING = new Season("春天","温暖");
//    public static final Season WINTER = new Season("冬天","寒冷");
//    public static final Season AUTUMN = new Season("秋天","凉爽");
//    public static final Season SUMMER = new Season("夏天","炎热");

    //1.将构造器私有化,目的防止直接new
    //2.去掉set相关方法,防止属性被修改
    //3.在Season内部,直接创建固定的对象
    //4.优化,可以加入final修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}