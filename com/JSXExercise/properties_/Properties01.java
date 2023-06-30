package com.JSXExercise.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //读取mysql.properties 文件,并得到ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while((line = br.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "值是：" + split[1]);
        }
    }
}
