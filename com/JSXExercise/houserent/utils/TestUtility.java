package com.JSXExercise.houserent.utils;

import com.JSXExercise.QQ.qqserver.Utility.Utility;

public class TestUtility {
    public static void main(String[] args) {
        //这是一个测试类,使用完毕就可以删除

        //要求输入一个字符串,长度最大为3
        String s = Utility.readString(3);
        System.out.println("s = " + s);

        //要求输入一个字符串,长度最大为10,如果用户直接回车,就给一个默认值"JiangShang"
        System.out.println("请输入字符串");
        String s2 = Utility.readString(10, "JiangShang");
        System.out.println("s2 = " + s2);
    }
}
