package com.JSXExercise.stringbuffer_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String -> StringBuffer
        String str = "hello tom";
        //方式一 使用构造器
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式二 使用append
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(str);

        //StringBuffer  -> String
        StringBuffer stringBuffer2 = new StringBuffer("jiang");
        //方式一 使用toString
        stringBuffer2.toString();
        //方式二 使用构造器
        String s1 = new String(stringBuffer2);
    }
}
