package com.JSXExercise.homework.homework26;

import java.util.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    //返回map中存放的所有T对象
    //遍历map[k-v], 将map的所有value(T entity),封装到ArrayList返回即可
    public List<T> list() {
        //创建ArrayList
        List<T> list = new ArrayList<>();

        //遍历map
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(get(key));
        }

        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }
}
