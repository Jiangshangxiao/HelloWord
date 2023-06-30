package com.JSXExercise.jdbc.myjdbc;

/**
 * @author 姜上晓
 * @version 1.0
 * 规定的jdbc接口(方法)
 */
public interface JdbcInterface {
    //连接
    Object getConnection();
    //crud
    void crud();
    //关闭连接
    void close();
}
