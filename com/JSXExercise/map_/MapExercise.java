package com.JSXExercise.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 姜上晓
 * @version 1.0
 * 使用HashMap添加3个员工对象，要求 键：员工id 值：员工对象
 * 并遍历显示工资>18000的员工(遍历方式最少两种) 员工类：姓名、工资、员工id
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, new Emp("jack", 300000, 1));
        map.put(2, new Emp("tom", 1000, 2));
        map.put(3, new Emp("milan", 12000, 3));

        //遍历两种方法
        //1.使用keySet -> 增强for
        System.out.println("=====第一种遍历方式=====");
        Set keySet = map.keySet();
        for (Object key: keySet) {
            Emp emp = (Emp) map.get(key);
            if (emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }

        //2.使用EntrySet -> 迭代器
        System.out.println("=====第二种遍历方式=====");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            //通过entry 取得key和value
            Emp emp = (Emp) entry.getValue();
            if (emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }
    }
}

class Emp {
    private String name;
    private double sal;
    private int id;

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
