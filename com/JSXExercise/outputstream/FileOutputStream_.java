package com.JSXExercise.outputstream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    /**
     * 演示使用FileOutputStream将数据写到文件中
     * 如果该文件不存在,则创建该文件
     */
    @Test
    public void writeFile() {
        //创建FileOutputStream对象
        String filePath = "D:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            //写入一个字节
            fileOutputStream.write('H');
            //写入字符串
            String str = "Jiang,world";
            //str.getBytes() 可以把 字符串 -> 字节数组
            fileOutputStream.write(str.getBytes());
            //
            fileOutputStream.write(str.getBytes(), 0, 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
