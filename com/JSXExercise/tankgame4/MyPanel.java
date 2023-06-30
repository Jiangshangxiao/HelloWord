package com.JSXExercise.tankgame4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 姜上晓
 * @version 1.0
 * 坦克大战的绘图区域
 */
@SuppressWarnings({"all"})
//监听键盘事件,实现KeyListener
//为了让Panel 不停的重绘子弹,需要将MyPanel实现Runnable,当作一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克,放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector,用于存放炸弹
    //当子弹击中坦克时,加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //定义三张炸弹图片,用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(500, 100); //初始化自己坦克
        hero.setSpeed(5); //设置自己坦克速度

        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //设置方向
            enemyTank.setDirect(2);
            //启动敌人坦克线程
            new Thread(enemyTank).start();
            //给该enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //加入enemyTank的Vector成员
            enemyTank.shots.add(shot);
            //启动shot对象
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充矩形,默认黑色

        //用封装方法画出自己坦克
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }

        //将hero的子弹集合shots,遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 4, 4, false);
            } else { //如果该shot对象已经消亡,就从子弹集合中移除
                hero.shots.remove(i);
            }
        }
        
        //如果bombs集合中有对象,就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让这个炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb.life为0, 就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        //画出敌人的坦克,遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if (enemyTank.isLive) { //当敌人坦克是存活的,才画出该坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画出enemyTank所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制子弹
                    if (shot.isLive) { //isLive = true
                        g.draw3DRect(shot.x, shot.y, 4, 4, false);
                    } else {
                        //从vector移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    //如果我们的坦克可以发射多个子弹
    //在判断我方子弹是否击中敌人坦克时,就需要把我们的子弹集合中
    //所有的子弹,都取出和敌人的所有坦克,进行判断
    public void hitEnemyTank() {
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            //判断是否击中了敌人坦克
            if (shot != null && shot.isLive) { //当我的子弹还存活
                //遍历敌人所有坦克
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    //判断敌人坦克是否击中我的坦克
    public void hitHero() {
        //遍历所有的敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank 对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中我的坦克
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }

    //编写方法,判断子弹是否击中敌人坦克
    public  void hitTank(Shot s, Tank enemyTank) {
        //判断击中坦克
        switch (enemyTank.getDirect()) {
            case 0: //坦克向上
            case 2: //坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人的坦克后,见enemyTank从Vector拿掉
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象,加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //坦克向右
            case 3: //坦克向左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                &&  s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //创建Bomb对象,加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克反向 (上下左右)
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0: //己方坦克
                g.setColor(Color.CYAN);
                break;
            case 1: //敌人坦克
                g.setColor(Color.YELLOW);
                break;
        }

        //根据坦克反向,来绘制对应的坦克
        //direct 表示方向(0: 向上 1 向右 2 向下 3 向左)
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false); //画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); //画出圆盖
                g.drawLine(x + 20, y + 30, x + 20, y); //画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false); //画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); //画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); //画出圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20); //画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false); //画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); //画出圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60); //画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false); //画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); //画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); //画出圆盖
                g.drawLine(x + 30, y + 20, x, y + 20); //画出炮筒
                break;
            default:
                System.out.println("暂时不处理");
        }
    }

    //编写方法,判断我方

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) { //按下W键
            //改变坦克方向
            hero.setDirect(0);
            //修改坦克坐标
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) { //按下D键
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) { //按下S键
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) { //按下A键
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        //如果用户按下的是J,就发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //判断hero的子弹是否销毁,发射一颗子弹
//            if (hero.shot == null || !hero.shot.isLive) {
//                hero.shotEnemyTank();
//            }
            //发射多课子弹
            hero.shotEnemyTank();
        }

        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void run() { //每隔10毫秒,重绘区域,刷新绘图区域
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断我们子弹是否击中了敌人坦克
            hitEnemyTank();
            //判断敌人坦克是否击中我们坦克
            hitHero();
            this.repaint();
        }

    }
}
