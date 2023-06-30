package com.JSXExercise.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们上课了");
            }
        });
    }
}

interface Bell { //接口
    void ring(); //方法
}

class CellPhone { //类
    public void alarmClock(Bell bell) { //形参是Bell接口类型
        bell.ring();
    }
}