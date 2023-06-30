package com.JSXExercise.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author 姜上晓
 * @version 1.0
 * 该类演示如何使用JDBCUtils
 */
public class JDBCUtils_Use {
    @Test
    public void testDML() {
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "update actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;
        //3. 创建preparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "周新驰");
            preparedStatement.setInt(2, 4);
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void testSelect() {
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建preparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            //执行
            set = preparedStatement.executeQuery();
            //遍历结果集合
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" +
                        borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }
}
