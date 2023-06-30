package com.JSXExercise.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework30 {
    public static void main(String[] args) throws IOException {
        /**
         * 要求:  使用BufferedReader读取一个文本文件，为每行加上行号，
         * 再连同内容一并输出到屏幕上。
         */
        String filePath = "D:\\story.txt";
        String line = "";
        int lineNum = 0;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            System.out.println(++lineNum + line);
        }
        if (br != null) {
            br.close();
        }
    }
}
