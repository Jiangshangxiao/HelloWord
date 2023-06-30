package com.JSXExercise.outputstream;

import java.io.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "D:\\a.jpg";
        String destFilePath = "D:\\a3.jpg";

        //创建BufferedOutputStream对象BufferedInputStream对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            //循环读写文件
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回-1就表示读取完毕
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
