package com.JSXExercise.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author 姜上晓
 * @version 1.0
 * 演示如何在面板上画出圆形
 */
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{
    //先定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序..");
    }
    public DrawCircle() {
        //初始化面板
        myPanel = new MyPanel();
        //把面板放入到窗口中
        this.add(myPanel);
        //设置窗口的大小
        this.setSize(400, 300);
        //当点击窗口的小x,程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //可以显示
    }
}

//1.先定义一个MyPanel,继承JPanel类,画圆形,就在画板上画
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) { //绘图方法
        super.paint(g);
        //画一个圆
        //g.drawOval(10, 10, 100, 100);

        //画直线
        //g.drawLine(10, 10, 100, 100);

        //画矩形边框
        //g.drawRect(10, 10, 100, 100);

        //填充矩形
        //先设置画笔的颜色
        //g.setColor(Color.blue);
        //g.fillRect(10, 10, 100, 100);

        //填充椭圆
        //g.setColor(Color.RED);
        //g.fillOval(10, 10, 50, 100);

        //画图片
        //1.获取图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage("C:/Users/92332/IdeaProjects/JSXJavaPractice/out/bg.png");
//        g.drawImage(image, 10, 10, 175, 221, this);

        //画字符串
        //先给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("宋体", Font.BOLD, 50));
        g.drawString("北京你好", 100, 100);
    }
}