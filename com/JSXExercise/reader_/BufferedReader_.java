package com.JSXExercise.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class BufferedReader_ {
    public static void main(String[] args) {
        String filePath = "D:\\a.txt";
        BufferedReader bufferedReader = null;
        //创建bufferedReader
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //读取
            String line; //按行读取
            //当返回null时,表示文件读取完毕
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
