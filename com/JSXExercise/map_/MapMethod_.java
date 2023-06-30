package com.JSXExercise.map_;

import java.util.HashMap;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class MapMethod_ {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("邓超", new Book("", 100));
    }
}

class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}