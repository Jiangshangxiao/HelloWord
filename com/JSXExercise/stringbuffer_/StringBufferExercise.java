package com.JSXExercise.stringbuffer_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class StringBufferExercise {
    public static void main(String[] args) {
        String price = "8123123.234";
        StringBuffer sb = new StringBuffer(price);

        for (int i = sb.lastIndexOf(".") - 3; i > 0 ; i -= 3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);
    }
}
