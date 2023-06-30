package com.JSXExercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的" +
                "静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通" +
                "过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的" +
                "人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且" +
                "重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结" +
                "构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的" +
                "语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以" +
                "随同网页在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术），" +
                "并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列" +
                "名字之后，最终，使用了提议者在喝一杯Java咖啡时无意提到的Java词" +
                "语）。5月23日，Sun公司在Sun world会议上正式发" +
                "布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软" +
                "等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产" +
                "品开发了相应的Java平台";
        //目标：匹配所有四个数字
        //1. \\d 表示一个任意的数字
        String regStr = "(\\d\\d)(\\d\\d)";
        //2. 创建模式对象
        Pattern pattern = Pattern.compile(regStr);
        //3. 创建匹配器
        Matcher matcher = pattern.matcher(content);

        //4. 开始匹配
        /**
         * matcher.find() 完成的任务
         * 1. 根据指定的规则，定位满足规则的字符串(比如1998)
         * 2. 找到后，将字符串的开始的索引记录到matcher对象的属性 int[] groups;
         *    groups[0] = 0, 把该字符串的结束的索引+1的值记录到groups[1] = 4
         * 3. 同时记录oldLast 的值为 子字符串的结束的索引 +1 的值即 4，即下次执行find时，就从4开始匹配
         *
         * matcher.group(0)
         * 1. 根据 groups[0] = 0 和 groups[1] = 4 的记录的位置，从content开始截取子字符串返回
         *    就是[0, 4)
         */
        while (matcher.find()) {
            //1.如果正则表达式有()即分组
            //2.取出匹配的字符串规则如下
            //3.group(0) 表示匹配到的子字符串
            //4.group(1) 表示匹配到的子字符串的第一组字符串
            //5.group(2) 表示匹配到的子字符串的第二组字符串
            //6.但是分组的数不能越界
            System.out.println("找到: " + matcher.group(0));
            System.out.println("第一组: " + matcher.group(1));
            System.out.println("第二组: " + matcher.group(2));
        }
    }
}
