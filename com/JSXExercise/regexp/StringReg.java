package com.JSXExercise.regexp;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class StringReg {
    public static void main(String[] args) {
        String content = "lkjasdfJDK1.3 JDK1.4";
        //使用正则表达式，将 JDK1.3 和 JDK1.4 替换成JDK
        content = content.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println(content);

        //要求验证一个手机号，要求必须是以138 139开头的
        content = "13688889999";
        if (content.matches("1(38|39)\\d{8}")) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }

        //要求按照 # 或者 - 或者 ~ 或者 数字 来分割
        content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
