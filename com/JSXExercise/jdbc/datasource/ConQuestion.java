package com.JSXExercise.jdbc.datasource;

import com.JSXExercise.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ConQuestion {
    @Test
    public void testCon() {
        //看看连接-关闭 connection 会耗时多久
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //使用传统的方法jdbc方式,得到连接
            Connection connection = JDBCUtils.getConnection();
            //
            //
            //关闭
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式5000次耗时 = " + (end - start));
    }
}
