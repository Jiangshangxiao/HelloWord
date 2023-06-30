package com.JSXExercise.thread_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }
}

//1.当一个类继承了Thread后就可以当做线程使用
class Cat extends Thread {
    int times = 0;
    @Override
    public void run() { //重写run方法,写上自己的逻辑
        while (true) {
            System.out.println("喵喵,我是小猫咪" + (++times));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 80) {
                break; //当times到80,退出while,这时退出线程
            }
        }
    }
}
