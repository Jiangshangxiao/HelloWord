package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示定位符的使用
 */
public class RegExp06 {
    public static void main(String[] args) {
        String content = "jiangshangxiao jjiang hhjiang";
        //以至少1个数字开头，后接任意个小写字母的字符串
        //String regStr = "^[0-9]+[a-z]*";

        //以至少1个数字开头, 必须以至少一个小写字符结束
        //String regStr = "^[0-9]+[a-z]+$";

        //表示匹配边界的jiang[这是的边界时指: 被匹配的字符串最后，也可以时空格的子字符串的后面]
        String regStr = "jiang\\b";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
