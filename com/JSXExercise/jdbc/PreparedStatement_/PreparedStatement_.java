package com.JSXExercise.jdbc.PreparedStatement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示PreparedStatement的使用
 */
public class PreparedStatement_ {
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
        //3.1 组织Sql, Sql语句的?就相当于占位符
        //String sql = "select name, pwd from admin where name = ? and pwd = ?";

        //添加记录
        String sql = "insert into admin values(?, ?)";


        //3.2 preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给?赋值
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("恭喜，登录成功");
        } else {
            System.out.println("抱歉，登录失败");
        }

        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
