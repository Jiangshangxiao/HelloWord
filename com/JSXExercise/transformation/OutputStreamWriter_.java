package com.JSXExercise.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示 OutputStreamWriter 使用
 * 把FileOutputStream 字节流,转成字符流OutputStreamWriter
 * 指定处理的编码 gbk/utf-8/utf8
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Jiang.txt";
        String charSet = "gbk";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hello");
        osw.close();
    }
}
