package com.JSXExercise.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class DBUtils_USE {
    @Test
    //使用apache-DBUtils 工具类 + druid 完成对表的crud操作
    public void testQueryMany() throws SQLException { //返回结果是多行的情况
        //1. 得到连接 (druid)
        //2. 使用DBUtils 类和接口，先引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回ArrayList结果集
        String sql = "select * from actor where id >= ?";
        //1. query 方法就是执行sql语句，得到resultSet ---封装到 ---> ArrayList集合中
        //2. 返回集合
        //3. connection: 连接
        //4. sql: 执行的sql语句
        //5. new BeanListHandler<>(Actor.class): 在将resultSet -> Actor对象 -> 封装到ArrayList
        //    底层使用反射机制 去获取Actor类的属性, 然后进行封装
        //6. 1就是给sql语句中的? 赋值, 可以又多个值, 因为是可变形参
        //7. 底层得到的resultSet,会在query中关闭,关闭PreparedStatement
        List<Actor> list =
                queryRunner.query(connection,sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor : list) {
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
        //1. 得到连接 (druid)
        //2. 使用DBUtils 类和接口，先引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回ArrayList结果集
        String sql = "select * from actor where id = ?";

        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示apache-dbutils + druid 完成查询结果是单行单列-返回的就是object
    @Test
    public void testScalar() throws SQLException {
        //1. 得到连接 (druid)
        //2. 使用DBUtils 类和接口，先引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        //4. 就可以执行相关的方法，返回ArrayList结果集
        String sql = "select name from actor where id = ?";

        //因为返回的是单行记录 <--->单个对象, 使用的Handler 是 ScalarHandler
        Object query = queryRunner.query(connection, sql, new ScalarHandler(), 2);
        System.out.println(query);

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示apache-dbutils + druid 完成dml(update, insert, delete)
    @Test
    public void testDML() throws SQLException {
        //1. 得到连接 (druid)
        //2. 使用DBUtils 类和接口，先引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        //4. 这里组织sql 完成update, insert, delete
        //String sql = "update actor set name = ? where id = ?";
        //String sql = "insert into actor values (null, '林青霞', '女', '1966-10-10', '116')";
        String sql = "delete from actor where id = ?";


        //1. 执行dml操作是queryRunner.update()
        //2. 返回的值是受影响的行数
        int affectedRow = queryRunner.update(connection, sql, 4);
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");
        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
