package com.JSXExercise.object;

public class Finalize_ {
    public static void main(String[] args) {
        Car bmw = new Car("宝马");
        //这时car对象就是一个垃圾,垃圾回收器就会销毁对象car,在销毁对象前就会调用该对象的finalize方法
        bmw = null;
    }
}
class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }


}
