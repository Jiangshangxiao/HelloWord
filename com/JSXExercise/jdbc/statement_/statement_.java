package com.JSXExercise.jdbc.statement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示statement 的注入问题
 */
public class statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.println("请输入管理员的名字: "); //next(): 当接收到空格或者 '就表示结束
        String admin_name = scanner.nextLine(); //nextLine(): 需要按下回车才算结束
        System.out.println("请输入管理员的密码: ");
        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1 .注册驱动
        Class.forName(driver);

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到Statement
        Statement statement = connection.createStatement();
        //4.组织Sql
        String sql = "select name, pwd from admin where name = '" + admin_name
                + "' and pwd = '" + admin_pwd + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("恭喜，登录成功");
        } else {
            System.out.println("抱歉，登录失败");
        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
