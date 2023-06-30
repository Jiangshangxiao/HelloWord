package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class RegExp13 {
    public static void main(String[] args) {
          String content = "我....我要....学学学学....编程Java";
//
        //1. 去掉所有的.

        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");

        System.out.println("content = " + content);
//
//        //2. 去掉重复的字
//        //(1) 使用 (.)\1+
//        //(2) 使用反向引用$1 来替换匹配到的内容
//        pattern = Pattern.compile("(.)\\1+");
//        matcher = pattern.matcher(content);
//
//        content = matcher.replaceAll("$1");
//        System.out.println("content = " + content);
         content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
    }
}
