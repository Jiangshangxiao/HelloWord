package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * Matcher 类的使用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello edu jack tom hello smith hello hspedu";
        String regStr = "hello.*";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("==================");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到: " + content.substring(matcher.start(), matcher.end()));
        }

        //整体匹配方法,常用于去校验某个字符串是否满足某个规则
        System.out.println(matcher.matches());

        //完成如果content 有 hspedu 替换成韩顺平教育
        regStr = "hspedu";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        //返回的2字符串才是替换后的字符串 原来的content不变化
        String newContent = matcher.replaceAll("韩顺平教育");
        System.out.println("newContent = " + newContent);
    }
}
