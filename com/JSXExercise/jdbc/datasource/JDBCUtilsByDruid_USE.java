package com.JSXExercise.jdbc.datasource;



import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class JDBCUtilsByDruid_USE {
    @Test
    public void testSelect() {
        //1.得到连接
        Connection connection = null;
        ArrayList<Actor> actors = new ArrayList<>();

        //2.组织一个sql
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建preparedStatement对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
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
                actors.add(new Actor(id, name, sex, borndate, phone));
            }
            System.out.println("actors集合数据 = " + actors);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
}
