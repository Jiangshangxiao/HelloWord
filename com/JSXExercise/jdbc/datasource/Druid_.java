package com.JSXExercise.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 姜上晓
 * @version 1.0
 * 测试druid的使用
 */
public class Druid_ {
    @Test
    public void testDruid_P() throws Exception {
        //1. 加入Druid jar包
        //2. 加入配置文件, 将该文件拷贝到项目的src目录
        //3. 创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4. 创建一个指定参数的数据库连接池
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("德鲁伊连接池5000次耗时 = " + (end - start));
    }
}
