package com.JSXExercise.tankgame2;

import javax.swing.*;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class JiangTankGame02 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        JiangTankGame02 jiangTankGame01 = new JiangTankGame02();
    }

    public JiangTankGame02() {
        mp = new MyPanel();
        this.add(mp); //把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
