package com.JSXExercise.homework;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Homework14 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 8);

        cellPhone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 10, 8);
    }
}

/*
1.计算器接口具有work方法,功能是运算,有一个手机类cellphone,定义方法testWork
测试计算功能,调用计算接口的work方法
2.要求调用CellPhone对象的testWork方法,使用上匿名内部类
 */
//编写接口
interface ICalculate {
    double work(double n1, double n2);
}

class CellPhone {
    //当调用testWork方法时,直接传入一个实现了ICalculate的匿名内部类
    public void testWork(ICalculate iCalculate, double n1, double n2) {
        double result = iCalculate.work(n1, n2);
        System.out.println("计算后的结果是 = " + result);
    }
}