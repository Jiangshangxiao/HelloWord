package com.JSXExercise.writer_;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\ok.txt";
        //创建BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello");
        bufferedWriter.newLine(); //插入一个和系统相关的换行符
        bufferedWriter.write("hello");
        bufferedWriter.write("hello");
        bufferedWriter.close();
    }
}
