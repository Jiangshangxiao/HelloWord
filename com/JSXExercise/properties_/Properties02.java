package com.JSXExercise.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来读取mysql.properties 文件

        //1.创建
        Properties properties = new Properties();
        //2.加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3.把K-v显示控制台
        properties.list(System.out);
        //4.根据key获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名 = " + user);
        System.out.println("密码是 = " + pwd);
    }
}
