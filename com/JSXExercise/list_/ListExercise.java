package com.JSXExercise.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        System.out.println("list = " + list);

        //在2号位插入一个元素
        list.add(1, "Jiang");
        System.out.println("list = " + list );

        //获取第五个元素
        System.out.println("第五个元素 = " + list.get(4));

        //删除第6个元素
        list.remove(5);
        System.out.println("list = " + list);

        //修改第7个元素
        list.set(6, "三国演义");
        System.out.println("list = " + list);

        //使用迭代器遍历列表
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}
