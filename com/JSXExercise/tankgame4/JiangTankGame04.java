package com.JSXExercise.tankgame4;

import javax.swing.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class JiangTankGame04 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        JiangTankGame04 jiangTankGame01 = new JiangTankGame04();
    }

    public JiangTankGame04() {
        mp = new MyPanel();
        //将mp 放入到Thread,并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); //把面板(就是游戏的绘图区域)
        this.setSize(1100, 850);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
