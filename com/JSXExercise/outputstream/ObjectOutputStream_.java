package com.JSXExercise.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) {
        //序列化后,保存的文件格式,不是存文本,而是按照他的格式来保存
        String filePath = "D:\\data.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            //序列化数据列D:\\data.dat
            objectOutputStream.writeInt(100); //int -> integer
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeChar('a');
            objectOutputStream.writeDouble(9.5);
            objectOutputStream.writeUTF("JIANG");
            //保存一个dog对象
            objectOutputStream.writeObject(new Dog("旺财", 10));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
