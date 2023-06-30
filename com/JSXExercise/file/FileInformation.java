package com.JSXExercise.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    //获取文件的信息
    @Test
    public void info() {
        //先创建文件对象
        File file = new File("D:\\news1.txt");

        //调用相应的方法,得到对应的信息
        System.out.println("文件名字 = " + file.getName());
        //获取文件绝对路径
        System.out.println("文件绝对路径 = " + file.getAbsolutePath());
        //获取文件父级目录
        System.out.println("文件父级目录 = " + file.getParent());
        //获取文件大小
        System.out.println("文件大小 = " + file.length());
    }
}
