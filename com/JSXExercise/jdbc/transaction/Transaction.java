package com.JSXExercise.jdbc.transaction;

import com.JSXExercise.jdbc.utils.JDBCUtils;

import java.sql.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Transaction {
    public static void main(String[] args) {
        //1.得到连接
        Connection connection = null;

        //2.组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql1 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建preparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); //执行第一条sql

            //int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate(); //执行第二条sql

            connection.commit();
        } catch (SQLException e) {
            //这里我们可以进行回滚,即撤销执行的SQL
            //默认回滚到事务开始的状态
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
