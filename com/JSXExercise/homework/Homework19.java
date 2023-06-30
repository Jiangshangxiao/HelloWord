package com.JSXExercise.homework;

/**
 * @author 姜上晓
 * @version 1.0
 * (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
 * (2) 编写方法 public static String reverse(String str, int start , int end)
 *
 */
public class Homework19 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("交换前:");
        System.out.println(str);
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("交换后:");
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {
        if( !(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = ' '; //交换辅助变量
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
