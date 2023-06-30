package com.JSXExercise.jdbc.myjdbc;

/**
 * @author 姜上晓
 * @version 1.0
 * mysql 数据库实现了jdbc接口[模拟][mysql厂商开发]
 */
public class MysqlJdbcImpl implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("得到mysql的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成mysql增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql增删改查");
    }
}
