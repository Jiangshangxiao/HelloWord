package com.JSXExercise.tankgame4;


import java.util.Vector;

/**
 * @author 姜上晓
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类,使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //判断如果shots.size() == 0,创建一颗子弹,放入到shots集合中
            if (isLive && shots.size() < 5) {
                Shot s = null;
                //判断坦克和方向,创建对应的子弹
                switch (getDirect()) {
                    case 0: //上
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1: //右
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2: //下
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3: //左
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0: //向上
                    //让坦克保持一个方向,走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        //休眠30毫秒
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //休眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 1: //向右
                    //让坦克保持一个方向,走30步
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        //休眠30毫秒
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //休眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2: //向下
                    //让坦克保持一个方向,走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        //休眠30毫秒
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //休眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3: //向左
                    //让坦克保持一个方向,走30步
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        //休眠30毫秒
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //休眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
            //然后随机改变坦克方向
            setDirect((int) (Math.random() * 4));
            //如果坦克死亡,就退出线程
            if (!isLive) {
                break;
            }
        }
    }
}
