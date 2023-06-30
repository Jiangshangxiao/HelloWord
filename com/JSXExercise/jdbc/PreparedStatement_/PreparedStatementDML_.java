package com.JSXExercise.jdbc.PreparedStatement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示PreparedStatement使用DML语句
 */
public class PreparedStatementDML_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.println("请输入要删除管理员的名字: "); //next(): 当接收到空格或者 '就表示结束
        String admin_name = scanner.nextLine(); //nextLine(): 需要按下回车才算结束
        //System.out.println("请输入管理员的密码: ");
        //String admin_pwd = scanner.nextLine();

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
        
        //添加记录
        //String sql = "insert into admin values(?, ?)";

        //修改记录
        //String sql = "update admin set pwd = ? where name = ?";

        //删除记录
        String sql = " delete from admin where name = ?";


        //3.2 preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给?赋值
        preparedStatement.setString(1, admin_name);

        //4.执行dml语句 使用executeUpdate
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");
        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
