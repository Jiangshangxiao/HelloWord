package com.JSXExercise.writer_;

import java.io.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) {
        String srcFilePath = "D:\\a.txt";
        String destFilePath = "D:\\a2.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            while ((line = br.readLine()) != null) {
                //没读取一行就写入
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
