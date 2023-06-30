package com.JSXExercise.tankgame5;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Shot implements Runnable {
    int x; //子弹x坐标、
    int y; //子弹y坐标
    int direct = 0; //子弹方向
    int speed = 10; // 子弹速度
    boolean isLive = true; //子弹是否存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { //射击
        while (true) {
            //休眠 50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向来改变x,y坐标
            switch (direct) {
                case 0: //上
                    y -= speed;
                    break;
                case 1: //右
                    x += speed;
                    break;
                case 2: //下
                    y += speed;
                    break;
                case 3: //左
                    x -= speed;
                    break;
            }
            //System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板的边界时,就应该销毁(把启动的子弹的线程销毁)
            //当子弹碰到敌人坦克时,也应该结束线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                //System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
