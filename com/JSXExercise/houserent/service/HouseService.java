package com.JSXExercise.houserent.service;

import com.JSXExercise.houserent.domain.House;

/**
 *HouseService.java -> 业务层
 * 定义一个House[],保存House对象
 * 1.响应HouseView的调用
 * 2.完成对房屋信息的各种操作(增删改查C(create)R(read)U(update)D(delete))
 */
public class HouseService {
    private House[] houses; //保存House对象
    private int houseNums = 1; //记录当前有多少个房屋信息
    private int idCount = 1; //记录当前的id增长到那个值了

    public HouseService(int size) {
        houses = new House[size]; //当创建HouseService对象时,指定数组大小
        //为了配合测试列表信息,这里初始化一个house对象
        houses[0] = new House(1, "jack", "112","宁远", 2000,"未出租");
    }

    //add方法,添加新对象,返回boolean
    public boolean add(House newHouse) {
        //判断是否还可以继续添加(暂时不考虑数组扩容的问题)
        if(houseNums == houses.length) {
            System.out.println("房屋已满,不能在添加了...");
            return false;
        }

        //把newHouse对象加入到数字最后
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCount);
        return true;
    }

    //del方法,删除一个房屋信息
    public boolean del(int delId) {
        //先找房屋信息对应的下标
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) { //要删除的房屋id,时数组下标为i的元素
                index = i; //使用index记录i
            }
        }

        if (index == -1) { //说明delId在数组中不存在
            System.out.println("删除失败,房屋编号不存在");
            return false;
        }

        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null; //把房屋信息的最后一个置空
        return true;
    }

    //find方法,删除一个房屋信息
    public House findById(int findId) {
        //遍历数组
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }

        return null;
    }

    public House[] list() {
        return houses;
    }
}
