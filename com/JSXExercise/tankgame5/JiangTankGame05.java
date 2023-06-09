package com.JSXExercise.tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class JiangTankGame05 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JiangTankGame05 jiangTankGame01 = new JiangTankGame05();
    }

    public JiangTankGame05() {
        System.out.println("请输入选择 1: 新游戏 2: 继续上局游戏");
        String key = scanner.next();
        mp = new MyPanel(key);
        //将mp 放入到Thread,并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); //把面板(就是游戏的绘图区域)
        this.setSize(1300, 850);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame中增加响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.out.println("监听到关闭窗口了");
            }
        });
    }
}
