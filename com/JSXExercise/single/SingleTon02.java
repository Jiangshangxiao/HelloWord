package com.JSXExercise.single;

/**
 * 懒汉式的单例模式
 */
public class SingleTon02 {
    public static void main(String[] args) {
        Cat cat = Cat.getInstance();
        System.out.println(cat);
    }
}

//希望在程序运行过程中,只能创建一个Cat对象
//使用单例模式
class Cat {
    private String name;
    private static Cat cat;

    //1.将构造器私有化
    //2.创建一个static属性对象
    //3.提供一个public的static方法,可以返回一个Cat对象
    private Cat(String name) {
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) { //如果还没有创建cat对象
            cat = new Cat("小可爱");
        }
        return cat;
    }
}
