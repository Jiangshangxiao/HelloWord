package com.JSXExercise.houserent.view;


import com.JSXExercise.houserent.domain.House;
import com.JSXExercise.houserent.service.HouseService;
import com.JSXExercise.QQ.qqserver.Utility.Utility;

/**
 * 1.显示界面
 * 2.接受用户的输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {

    private boolean loop = true; //控制显示菜单
    private char key = ' '; //接受用户选择
    private HouseService houseService = new HouseService(10); //设置数组的大小为10

    //编写delHouse()接受输入的id,调用Service的del方法
    public void delHouse() {
        System.out.println("==============删除房屋信息===============");
        System.out.println("请输入想要删除的房屋编号(-1退出):");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("==============放弃删除房屋信息===============");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("==============删除房屋信息成功===============");
            } else {
                System.out.println("==============删除房屋信息失败===============");
            }
        } else {
            System.out.println("==============放弃删除房屋信息===============");
        }
    }

    //编写addHouse()接受输入,创建House对象,调用add方法
    public void addHouse() {
        System.out.println("==============添加房屋信息===============");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.println("电话: ");
        String phone = Utility.readString(12);
        System.out.println("地址: ");
        String address = Utility.readString(16);
        System.out.println("月租: ");
        int rent = Utility.readInt();
        System.out.println("状态: ");
        String state = Utility.readString(3);
        //创建一个新的House对象,id系统分配的,用户不能输入
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("================添加房屋成功================");
        } else {
            System.out.println("================添加房屋失败================");
        }
    }

    //编写liseHouses()显示房屋列表
    public void listHouses() {
        System.out.println("=========================房屋列表========================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/以出租)");
        House[] houses = houseService.list(); //得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                System.out.println(houses[i]);
            }
        }
        System.out.println("======================房屋列表显示完毕=====================");
    }

    //exit()退出软件
    public void exit() {
        //使用Utility提供的方法,完成确认
        char choice = Utility.readConfirmSelection();
        if (choice == 'y') {
            loop = false;
        }
    }

    //根据id查找房屋信息
    public void findHouse() {
        System.out.println("=============查找房屋信息==============");
        System.out.println("请输入你要查找的id: ");
        int findId = Utility.readInt();
        //调用方法
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("=============查找房屋id不存在==============");
        }
    }

    //根据id修改房屋信息
    public void update() {
        System.out.println("=============修改房屋信息==============");
        System.out.println("请选择要修改房屋编号(-1表示退出): ");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("=============你放弃了修改房屋信息==============");
            return;
        }

        //根据输入的updateId,查找对象
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("=============修改房屋信息的编号不存在==============");
            return;
        }

        System.out.println("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, ""); //这里用户直接回车要是不修改,默认""
        if (!"".equals(name)) { //修改
            house.setName(name);
        }

        System.out.println("电话(" + house.getPhone() + "): ");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }

        System.out.println("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(12, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }

        System.out.println("租金(" + house.getRent() + "): ");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }

        System.out.println("状态(" + house.getState() + "): ");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }

        System.out.println("=============修改房屋信息成功==============");
    }

    //显示主菜单
    public void mainMenu() {

        do {
            System.out.println("=============房屋出租系统菜单==============");
            System.out.println("\t\t\t1  新增房源");
            System.out.println("\t\t\t2  查找房屋");
            System.out.println("\t\t\t3  删除房屋信息");
            System.out.println("\t\t\t4  修改房屋信息");
            System.out.println("\t\t\t5  显示房屋列表");
            System.out.println("\t\t\t6  退出软件");
            System.out.println("请输入你的选择(1-6):");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }
}
