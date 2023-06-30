package com.JSXExercise.reader_;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class FIleReader_ {
    public static void main(String[] args) {
        String filePath = "D:\\story.txt";
        FileReader fileReader = null;
        int data = ' ';
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read,单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
