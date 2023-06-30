package com.JSXExercise.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}

//猴子
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + "会爬树....");
    }
}

//接口
interface FishAble {
    void swimming();
}

interface BirdAble {
    void flying();
}

//继承
class LittleMonkey extends Monkey implements FishAble,BirdAble{

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "通过学习,可以向鱼儿一样游泳了....");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "通过学习,可以向鸟儿一样飞翔了....");
    }
}