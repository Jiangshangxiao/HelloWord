package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示限定符的使用
 */
public class RegExp05 {
    public static void main(String[] args) {
        String content = "a111111111111aaaahello";
        //a{3},1{4},\\d{2}
        //String regStr = "a{3}"; //表示匹配 aaa
        //String regStr = "1{4}"; //表示匹配 1111
        //String regStr = "\\d{2}"; //表示匹配 两位的任意数字字符
        //String regStr = "a{3,4}"; //表示匹配 aaa 或者 aaaa ,java匹配默认贪婪匹配，即尽可能匹配多的
        //String regStr = "\\1+"; //匹配一个1或者多个1
        //String regStr = "\\d+"; //匹配一个数字或者多个数字
        //String regStr = "1*"; //匹配0个1或者多个1
        String regStr = "a1?"; //匹配a或者a1

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
