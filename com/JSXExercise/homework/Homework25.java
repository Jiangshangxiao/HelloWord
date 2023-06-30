package com.JSXExercise.homework;

import java.util.*;

/**
 * @author 姜上晓
 * @version 1.0
 *
 *  按要求完成下列任务
 *   1）使用HashMap类实例化一个Map类型的对象m，键（String）和值（int）分别用于存储员工的姓名和工资，
 *   存入数据如下：	jack—650元；tom—1200元；smith——2900元；
 *   2）将jack的工资更改为2600元
 *   3）为所有员工工资加薪100元；
 *   4）遍历集合中所有的员工
 *   5）遍历集合中所有的工资
 *
 */
@SuppressWarnings({"all"})
public class Homework25 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);

        m.put("jack", 2600);
        System.out.println(m);

        //为所有员工加薪100元
        Set keySet = m.keySet();
        for (Object key : keySet) {
            m.put(key,(Integer) m.get(key) + 100);
        }
        System.out.println(m);

        //遍历EntrySet
        Set entrySet = m.entrySet();
        //迭代器
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        Collection values = m.values();
        for (Object value: values) {
            System.out.println("工资 = " + value);
        }

    }
}
