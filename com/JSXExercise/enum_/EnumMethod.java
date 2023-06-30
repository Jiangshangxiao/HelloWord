package com.JSXExercise.enum_;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示Enum类的各种方法的使用
 */
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season枚举类,来演示各种方法
        Season autumn = Season.AUTUMN;
        //输出枚举对象的名字
        System.out.println(autumn.name());
        //ordinal()输出的是该枚举对象的次序/编号,从0开始编号
        System.out.println(autumn.ordinal());
        //values方法,返回Season[]
        //含有定义的所有枚举对象
        Season[] values = Season.values();
        for (Season season : values) { //增强for循环
            System.out.println(season);
        }
        //valueOf:将字符串转换成枚举对象,要求字符串必须为已有的常量名,否则报错
        Season autumn1 = Season.valueOf("AUTUMN");
        System.out.println("autumn1 = " + autumn1);
        //compareTo: 比较两个枚举常量,比较的就是编号
        System.out.println(Season.AUTUMN.compareTo(Season.SUMMER));
    }
}
