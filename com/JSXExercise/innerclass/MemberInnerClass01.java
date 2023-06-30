package com.JSXExercise.innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //外部其他类,使用成员内部类的三种方式
        //第一种方式
        Outer08.Innter08 innter08 = outer08.new Innter08();
        innter08.say();

        //第二种方式,在外部类中,编写一个方法,可以返回Inner08对象
        Outer08.Innter08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();

        //第三种方式,
    }
}
 class Outer08 {
    private int n1 = 10;
    public String name = "张三";

    private void hi() {
        System.out.println("hi()方法....");
    }

    //成员内部类可以添加任意的修饰符
    protected class Innter08 { //成员内部类
        public void say() {
            //可以直接访问外部类的所有成员,包含私有的
            System.out.println("Outer08 的n1 = " + n1 + " name = " + name);
            hi();
        }
    }

    //方法,返回一个Inner08实例
    public Innter08 getInner08Instance() {
        return new Innter08();
    }

    //写方法
    public void t1() {
        //使用成员内部类
        Innter08 innter08 = new Innter08();
        innter08.say();
    }
 }