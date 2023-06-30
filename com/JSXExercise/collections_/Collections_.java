package com.JSXExercise.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        //创建一个ArrayList集合用于测试
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");

        System.out.println(list);

        //reverse(List):反转list中的顺序
        Collections.reverse(list);
        System.out.println(list);

        //shuffle(List):对List集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);

        //sort(List):根据元素的自然顺序对指定List集合元素升序排序
        Collections.sort(list);
        System.out.println(list);

        //sort(List, Comparator):根据指定的Comparator产生的顺序对List集合元素排序
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("字符串长度大小排序 = " + list);

        //swap(List, int, int):将指定list集合中的i处元素和j处元素进行交换
        Collections.swap(list, 0, 1);
        System.out.println(list);

        //Object max(Collection):根据元素的自然排序,返回给定集合中的最大元素
        System.out.println("自然顺序中的最大元素：" + Collections.max(list));

        //Object max(Collection, Comparator):根据Comparator指定的顺序,返回给定集合中的最大元素
        Object maxObject = Collections.max(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("长度最大的元素：" + maxObject);

        //int frequency(Collection Object):返回指定集合中指定元素的出现次数
        System.out.println("tom出现的次数 = " + Collections.frequency(list, "tom"));

        //void copy(List dest, List sre): 将src中的内容复制到dest中
        ArrayList dest = new ArrayList();
        //为了完成一个完整的拷贝,需要像欸dest赋值,大小和list。size()一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        //拷贝
        Collections.copy(dest, list);
        System.out.println("dest = " + dest);

        //boolean replaceAll(List list, Object oldVal, Object newVal)
        //使用新值替换List对象所有的旧值
        Collections.replaceAll(list, "tom", "汤姆");
        System.out.println(list);
    }
}
