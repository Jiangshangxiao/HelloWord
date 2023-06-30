package com.JSXExercise.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示读取文件
     * 单个字节的读取,效率比较低
     */
    @Test
    public void readFile01() {
        String filePath = "D:\\hello.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //如果返回-1,表示读取完毕
            while ((readDate = fileInputStream.read()) != -1) {
                System.out.print((char) readDate);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭文件流, 释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 演示使用字节数组读取
     */
    @Test
    public void readFile02() {
        String filePath = "D:\\hello.txt";
        int readDate = 0;
        //字节数组
        byte[] buf = new byte[8];
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //如果返回-1,表示读取完毕
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭文件流, 释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
