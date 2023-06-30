package com.JSXExercise.houserent;

import com.JSXExercise.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象,并且显示主菜单,程序入口
        new HouseView().mainMenu();
        System.out.println("===你退出了房屋出租系统===");
    }
}
