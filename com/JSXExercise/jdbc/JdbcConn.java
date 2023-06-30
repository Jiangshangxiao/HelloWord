package com.JSXExercise.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 姜上晓
 * @version 1.0
 * 分析java 连接mysql的5种方式
 */
public class JdbcConn {

    @Test
    //方式1
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db01";
        // 将用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        // user 和 password 是规定好的，后面的值根据实际情况写
        properties.setProperty("user", "root"); //用户名
        properties.setProperty("password", "asdfgh"); //密码

        Connection connect = driver.connect(url, properties);
        // 3. 执行sql
        //String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
        //String sql = "update actor set name='周星驰' where id = 1";
        String sql = "delete from actor where id = 1";
        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是dml语句, 返回的就是影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");
    }

    //方式2
    @Test
    public void connect02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类, 动态加载，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/db01";
        // 将用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        // user 和 password 是规定好的，后面的值根据实际情况写
        properties.setProperty("user", "root"); //用户名
        properties.setProperty("password", "asdfgh"); //密码

        Connection connect = driver.connect(url, properties);
        // 3. 执行sql
        //String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
        //String sql = "update actor set name='周星驰' where id = 1";
        String sql = "delete from actor where id = 1";
        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是dml语句, 返回的就是影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");
    }

    //方式3 使用DriverManager 替代Driver进行统一管理
    @Test
    public void connect03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        //使用放射加载Driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        //创建url和user和password
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "asdfgh";

        DriverManager.registerDriver(driver); //注册Driver驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种方式 = " + connection);
    }

    //方式4: 使用Class.forName 自动完成注册驱动，简化代码
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        // 使用反射加载了Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

        //创建url和user和password
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "asdfgh";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("第4中方式 = " + connection);
    }

    //方式5: 在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第五种方式 = " + connection);
    }
}
