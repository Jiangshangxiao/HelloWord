package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示字符匹配符的使用
 */
public class RegExp03 {
    public static void main(String[] args) {
        String content = "a11c8abcABC@";
        //String regStr = "[a-z]"; //匹配a-z之间任意一个字符
        //String regStr = "[A-Z]"; //匹配A-Z之间任意一个字符
        //String regStr = "abc"; //匹配abc字符串[默认区分大小写]
        //String regStr = "(?i)abc"; //匹配abc字符串[不区分大小写]
        //String regStr = "[0-9]"; //匹配0-9之间任意一个字符
        //String regStr = "[^a-z]"; //匹配不在a-z之间任意一个字符
        //String regStr = "[abc]"; //匹配在abcd中任意一个字符
        //String regStr = "\\D"; //匹配不在0-9中任意一个字符
        //String regStr = "\\w"; //匹配字母，数字，下划线
        //String regStr = "\\W"; //匹配 等价于 [^a-zA-Z0-9_]
        //\\s 匹配任何空白字符(空格，制表符等)
        //String regStr = "\\s";
        //\\S 匹配任何非空白字符, 和\\s刚好相反
        //String regStr = "\\S";
        // 匹配出\n之外的所有字符，如果要匹配。本身则需要使用 \\.
        String regStr = "\\.";


        //当创建Pattern对象时，指定 Pattern.CASE_INSENSITIVE, 表示匹配时不区字母大小写
        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
