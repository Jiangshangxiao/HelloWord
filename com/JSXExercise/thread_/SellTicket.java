package com.JSXExercise.thread_;

/**
 * @author 姜上晓
 * @version 1.0
 * 使用多线程,模拟三个窗口同时售票100
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
    }
}

//使用Thread方式
class SellTicket01 implements Runnable {
    private static int ticketNum = 100; //让多个线程共享ticketNum
    private boolean loop = true;

    public synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束...");
            loop = false;
            return;
        }
        //休眠50毫秒
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                + "剩余票数=" + (--ticketNum));
    }

    @Override
    public void run() {
        while (loop) {
            sell();
            if (ticketNum <= 0) {
                break;
            }
        }
    }
}
