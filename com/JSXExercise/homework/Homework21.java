package com.JSXExercise.homework;

/**
 * @author 姜上晓
 * @version 1.0
 * 编写方法: 完成输出格式要求的字符串 编写java程序，
 * 输入形式为： Han shun Ping的人名，以Ping,Han .S的形式打印 出来 。其中.S是中间单词的首字母
 */
public class Homework21 {
    public static void main(String[] args) {
        String name = "Han shun Ping";
        printName(name);
    }

    public static void printName(String str) {
        if (str == null) {
            System.out.println("str 不能为空");
            return;
        }

        String[] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("输入的字符串格式不对");
            return;
        }

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
