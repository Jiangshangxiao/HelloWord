package com.JSXExercise.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathName)
    @Test
    public void create01() {
        String filePath = "D:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式2 new File(File parent, String child)
    //根据父目录文件+子路径构建
    @Test
    public void create02() {
        File file = new File("D:\\");
        String fileName = "news2.txt";
        File file1 = new File(file, fileName);

        try {
            file1.createNewFile();
            System.out.println("创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式3 new File(String parent, String child)
    //根据父目录+子路径构建
    @Test
    public void creat03() {
        String parentPath = "D:\\";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
