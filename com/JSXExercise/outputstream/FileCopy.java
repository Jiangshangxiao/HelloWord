package com.JSXExercise.outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        //完成文件拷贝, 将 D:\\a.jpg 拷贝到 C:\\
        String srcfilePath = "D:\\a.jpg";
        String destFilePath = "D:\\a2.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcfilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //读取到后,就写入到文件通过 fileOutputStream
                //边读边写
                fileOutputStream.write(buf, 0, readLen);
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
