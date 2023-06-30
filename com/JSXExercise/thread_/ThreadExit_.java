package com.JSXExercise.thread_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        System.out.println("main线程休眠10s");
        Thread.sleep(10 * 1000);
        t.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T Thread 运行中....");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}