package com.JSXExercise.printstream_;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //在默认情况下,PrintStream 输出数据的位置是显示器
        out.print("hello");
        //因为print底层使用的是write,所以可以直接调用write进行打印
        out.write("JIANG".getBytes());
        out.close();

        //可以修改打印流输出的位置/设备
        //1.输出修改到"D:\\f1.txt"
        System.setOut(new PrintStream("D:\\f1.txt"));
        System.out.println("hello,JIANG");
    }
}
