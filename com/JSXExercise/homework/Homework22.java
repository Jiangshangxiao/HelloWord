package com.JSXExercise.homework;

/**
 * @author 姜上晓
 * @version 1.0
 * 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
 */
public class Homework22 {
    public static void main(String[] args) {
        String str = "abcJiang U 123123";
        countStr(str);
    }

    public static void countStr(String str) {
        if (str == null) {
            System.out.println("输入不能为 null");
            return;
        }
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numCount++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCount++;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCount++;
            }
        }
        System.out.println("数字有：" + numCount);
        System.out.println("小写字母有：" + lowerCount);
        System.out.println("大写字母有：" + upperCount);
    }
}
