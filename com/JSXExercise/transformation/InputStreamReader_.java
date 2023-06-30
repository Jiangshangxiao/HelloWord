package com.JSXExercise.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\a.txt";
        //1.把FileInputStream 转成InputStreamReader
        //2.指定编码UTF-8
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        //3.把InputStreamReader 传入Buffered
        BufferedReader br = new BufferedReader(reader);
        //4.读取
        String s = br.readLine();
        System.out.println("读取内容 = " + s);
        //5.关闭外层流
        br.close();
    }
}
