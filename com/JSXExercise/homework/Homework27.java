package com.JSXExercise.homework;

import java.util.Scanner;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework27 {
    public static void main(String[] args) {
        A_ a = new A_();
        B b = new B(a);
        a.start();
        b.start();

    }
}

//创建A线程类
class A_ extends Thread {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            //输出1-100
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

//直到第2个线程从键盘读取了"Q"命令
class B extends Thread {
    private A_ a;
    private Scanner scanner = new Scanner(System.in);

    public B(A_ a) { //从构造其中,直接传入A类对象
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            //接收到用户的输入
            System.out.println("请输入你的指令(Q)表示退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                //已通知的方式结束A线程、
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}
