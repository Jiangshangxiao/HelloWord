package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 选择匹配符
 */
public class RegExp04 {
    public static void main(String[] args) {
        String content = "jiangshangxiao 姜 上晓";
        String regStr = "jiang|上|晓";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group());
        }

    }
}
