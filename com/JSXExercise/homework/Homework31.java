package com.JSXExercise.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework31 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * (1) 要编写一个dog.properties   name=tom age=5 color=red
         * (2) 编写Dog 类(name,age,color)  创建一个dog对象，读取dog.properties 用相应的内容完成属性初始化, 并输出
         * (3) 将创建的Dog 对象 ，序列化到 文件 e:\\dog.dat 文件
         */
        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + "";

        Dog dog = new Dog(name, age, color);

        //将创建的Dog对象,序列化到文件dog.dat文件
        String serFilePath = "D:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);

        oos.close();
        m1();
    }

    //编写一个方法,反序列化dog
    @Test
    public static void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "D:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("====反序列化后的dog====");
        System.out.println(dog);
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
