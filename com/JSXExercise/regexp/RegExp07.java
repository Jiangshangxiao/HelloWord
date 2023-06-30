package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 分组
 */
public class RegExp07 {
    public static void main(String[] args) {
        String content = "jiangshangxiao s7789 nn1123han";
        //下面是非命名分组
        //1. matcher.group(0) 得到匹配到的字符串
        //2. matcher.group(1) 得到匹配到的字符串的第一个分组内容
        //3. matcher.group(2) 得到匹配到的字符串的第二个分组内容
        //String regStr = "(\\d\\d)(\\d\\d)";

        //命名分组
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
            System.out.println("找到 " + matcher.group("g1"));
            System.out.println("找到 " + matcher.group(2));
        }
    }
}
