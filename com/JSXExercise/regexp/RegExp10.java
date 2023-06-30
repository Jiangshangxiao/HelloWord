package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 正则表达式的应用实例
 */
public class RegExp10 {
    public static void main(String[] args) {
        String content = "13588889999";
        //1.汉字
        //String regStr = "^[\u0391-\uffe5]+$";
        //2.邮政编码
        //要求: 是1-9开头的一个六位数， 比如: 123890
        //String regStr = "^[1-9]\\d{5}$";
        //3.QQ号码
        //要求: 是1-9开头的一个(5位数-10位数) 比如: 12389, 1345687
        //String regStr = "^[1-9]\\d{4,9}$";
        //4.手机号码
        //要求: 必须以13,14,15,18开头的11位数, 比如13588889999
        String regStr = "^1[3|4|5|8]\\d{9}$";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }
}
