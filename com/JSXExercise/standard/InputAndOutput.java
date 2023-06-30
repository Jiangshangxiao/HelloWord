package com.JSXExercise.standard;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class InputAndOutput {
    public static void main(String[] args) {
        //System.in 编译类型 InputStream
        //System.in 运行类型 BufferedInputStream
        //表示便准输入 键盘
        System.out.println(System.in.getClass());

        //System.out 编译类型 PrintStream
        //System.out 运行类型 PrintStream
        //表示标准输入 显示器
        System.out.println(System.out.getClass());
    }
}
