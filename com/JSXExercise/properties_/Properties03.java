package com.JSXExercise.properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties类来创建配置文件,修改配置内容

        Properties properties = new Properties();
        //创建
        //如果该文件没有这个key,就是创建
        //如果该文件有这个key,就是修改
        properties.setProperty("charSet", "utf8");
        properties.setProperty("user", "汤姆");
        properties.setProperty("pwd", "abc111");

        //将K-v存储文件中
        properties.store(new FileOutputStream("src\\mysql02.properties"), null);

    }
}
