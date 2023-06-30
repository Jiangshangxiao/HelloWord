package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class RegExp11 {
    public static void main(String[] args) {
        String content = "https://www.bilibili.com/video/BV1fh411y7R8/?p=894&spm_id_from=pageDriver&vd_source=5b9b4e2d66cc33578d46132b55f8cfdf";

        /**
         * 1.先确定url的开始部分 https:// | 或者 http://
         * 2.然后通过([\w-]+\.)+[\w-]+ 匹配www.bilibili.com
         */
        String regStr = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#_]*)?$"; //[.]表示匹配就是.本身

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }
}
