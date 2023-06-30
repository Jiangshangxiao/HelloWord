package com.JSXExercise.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 * 将各个功能对应一个方法
 */
public class SmallChangeSysOop {

    //定义相关的变量
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //2.完成零钱通明细
    //(1)可以把收益入账和消费,保存到数组(2)可以使用对象(3)简单的话可以使用String拼接
    String details = "------------------零钱通明细--------------------";

    //3.完成收益入账
    //定义新的变量
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //4.消费
    //定义新变量,保存消费的原因
    String note = "";

    //先完成显示菜单,并可以选择
    public void mainMenu() {
        do {
            System.out.println("\n=============选择零钱通菜单============");
            System.out.println("\t\t\t1 零钱同明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退  出");

            System.out.println("请选择(1-4):  ");
            key = scanner.next();

            //使用switch分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("你的选择有误,请重新选择");
            }
        } while (loop);

        System.out.println("-----退出了零钱通-----");
    }

    //完成零钱通明细
    public void detail() {
        System.out.println(details);
    }

    //完成收益入账
    public void income() {
        System.out.println("收益入账金额:");
        money = scanner.nextDouble();
        //money的值范围校验
        //找出不正确的金额条件,然后给出提示,就直接break
        if (money <= 0) {
            System.out.println("收益入账金额需要大于0");
            return;
        }

        balance += money;

        //拼接消费信息到details
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "账户金额 " +balance;

    }

    //完成消费
    public void pay() {
        System.out.println("消费金额:");
        money = scanner.nextDouble();

        //money的值范围校验
        //找出不正确的金额条件,然后给出提示,就直接break
        if (money <= 0 || money > balance) {
            System.out.println("消费金额应该在0-" + balance);
            return;
        }

        System.out.println("消费说明:");
        note = scanner.next();
        balance -= money;
        //拼接消费信息到details
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "账户金额 " +balance;
    }

    //完成退出
    public void exit() {
        // 用户输入4退出时，给出提示"你确定要退出吗? y/n"，
        // 必须输入正确的y/n ，否则循环输入指令，直到输入y 或者 n
        //1.定义一个变量choice,接收用户的输入
        //2.使用while + break,来处理接收到的输入时y或者n
        //3.退出while后,在判断choice是y还是n,就可以决定是否退出
        String choice = "";
        while (true) { //要求用户必须输入y/n ,否则就一直循环
            System.out.println("你确定要退出吗? y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }

        //当用户退出while后,进行判断
        if (choice.equals("y")) {
            loop = false;
        }
    }
}
