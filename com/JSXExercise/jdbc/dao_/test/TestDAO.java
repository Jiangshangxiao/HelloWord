package com.JSXExercise.jdbc.dao_.test;

import com.JSXExercise.jdbc.dao_.dao.ActorDAO;
import com.JSXExercise.jdbc.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class TestDAO {
    //测试ActorDAO 对 actor表crud操作
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        //1. 查询
        String sql = "select * from actor where id >= ?";
        List<Actor> actors = actorDAO.queryMulti(sql, Actor.class, 1);
        System.out.println("===查询结果===");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2. 查询单行记录
        String sql1 = "select * from actor where id = ?";
        Actor actor1 = actorDAO.querySingle(sql1, Actor.class, 2);
        System.out.println("===查询单行结果===");
        System.out.println(actor1);

        //3. 查询单行单列
        String sql2 = "select name from actor where id = ?";
        Object o = actorDAO.queryScalar(sql2, 2);
        System.out.println("===查询单行单列值===");
        System.out.println(o);

        //4. dml操作 insert, update, delete
        String sql3 = "insert into actor values (null, ?, ?, ?, ?)";
        int update = actorDAO.update(sql3, "JSX", "男","1990-11-11", "119");
        System.out.println("===执行dml操作===");
        System.out.println(update == 0 ? "执行没有影响表" : "执行成功");
    }

}
