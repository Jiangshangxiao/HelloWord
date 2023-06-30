package com.JSXExercise.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("红楼梦", "施耐庵", 19));
        list.add(new Book("三国演义", "罗贯中", 80));

        //遍历
        for (Object o: list) {
            System.out.println(o);
        }

        //冒泡排序
        sort(list);
        System.out.println("排序后");
        //遍历
        for (Object o: list) {
            System.out.println(o);
        }
    }

    //价格从小到大
    public static void sort(List list) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                //取出对象
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}
