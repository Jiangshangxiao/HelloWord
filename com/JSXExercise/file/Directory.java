package com.JSXExercise.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Directory {
    public static void main(String[] args) {

    }

    //判断 D:\\news1.txt是否存在,如果存在就删除
    @Test
    public void m1() {
        String filePath = "D:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在");
        }
    }

    //判断 D:\\demo02 是否存在,存在就删除,否则提示不存在
    @Test
    public void m2() {
        String filePath = "D:\\demo02";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在");
        }
    }

    //判断 D:\\demo\\a\\b\\c 目录是否存在,如果存在就提示已经存在,否则就创建
    @Test
    public void m3() {
        String filePath = "D:\\demo\\a\\b\\c";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println(filePath + " 存在");
        } else {
            if (file.mkdirs()) {
                System.out.println(filePath + " 创建成功");
            } else {
                System.out.println(filePath + " 创建失败");
            }
        }
    }
}
