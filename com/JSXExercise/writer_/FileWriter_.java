package com.JSXExercise.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "D:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);
            //1.write(int)
            fileWriter.write('H');
            //2.write(char[]):写入指定数组
            fileWriter.write(chars);
            //3.write(char[], off, len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
            //4.write(String):写入整个字符串
            fileWriter.write(" 你好北京~");
            //5.Wirte(String, off, len):写入字符串的指定部分
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
