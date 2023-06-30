package com.JSXExercise.homework;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework28 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.setName("t1");
        Thread thread1 = new Thread(t);
        thread1.setName("t2");
        thread.start();
        thread1.start();
    }
}

//编程取款的线程
//1.涉及多个线程共享资源,所以使用实现Runnable方式
//2.每次取出1000
class T implements Runnable {
    private int money = 10000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //判断余额是否为零
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000 当前余额=" + money);

                //休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}