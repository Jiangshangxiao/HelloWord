package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 * 反向引用
 */
public class RegExp12 {
    public static void main(String[] args) {
        String content = "hello333333 jack1221 tom11 jack22 yyy xxx 12321-333999111";
        //匹配两个连续的相同数字
        //String regStr = "(\\d)\\1";
        //匹配五个连续的相同数字
        //String regStr = "(\\d)\\1{4}";
        //匹配个位与千位相同,十位与百位相同的数
        //String regStr = "(\\d)(\\d)\\2\\1";
        /**
         * 请在字符串中检索商品编号,形式如:12321-333999111 这样的号码
         * 要求满足前面是一个五位数,然后一个-号,然后是一个九位数,连续的每三位要相同
         */
        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
