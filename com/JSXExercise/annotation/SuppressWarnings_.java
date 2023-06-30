package com.JSXExercise.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class SuppressWarnings_ {

    //1.当不希望看到警告的时候,可以使用SuppressWarnings注解来抑制警告信息
    //2.在{""}中,可以写入你希望抑制(不显示)警告信息
    @SuppressWarnings({"rawtypes", "unchecked", "unused"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
}
