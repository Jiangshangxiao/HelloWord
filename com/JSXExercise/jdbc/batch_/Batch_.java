package com.JSXExercise.jdbc.batch_;

import com.JSXExercise.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示java的批处理
 */
public class Batch_ {
    //传统方法，添加5000条数据到admin2
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis(); //开始时间
        for (int i = 0; i < 5000; i++) { //添加5000行数据
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式耗时 = " + (end - start));
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }

    //使用批量方式添加数据
    @Test
    public void batch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis(); //开始时间
        for (int i = 0; i < 5000; i++) { //添加5000行数据
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.addBatch();
            //当有1000条记录时，在批量执行
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量处理的方式耗时 = " + (end - start));
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
