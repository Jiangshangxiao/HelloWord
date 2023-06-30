package com.JSXExercise.tankgame3;

import javax.swing.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class JiangTankGame03 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        JiangTankGame03 jiangTankGame01 = new JiangTankGame03();
    }

    public JiangTankGame03() {
        mp = new MyPanel();
        //将mp 放入到Thread,并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); //把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
