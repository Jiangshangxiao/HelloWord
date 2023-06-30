package com.JSXExercise.jdbc.myjdbc;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection(); //通过接口来条用实现类
        jdbcInterface.crud();
    }
}
