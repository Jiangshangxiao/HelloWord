package com.JSXExercise.innerclass;

/**
 * 演示局部内部类的使用
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02 { //内部类
    private int n1 = 100;
    private void m2() { //私有方法
        System.out.println("Outer02 m2()");
    }
    public void m1() { //方法
        //局部内部类是定义在外部类的局部位置,通常在方法内
        final class Inner02 { //局部内部类,本质还是一个类
            //可以直接访问外部类的所有成员,包含私有的
            //不能添加访问修饰符,但是可以使用final修饰
            //作用域：仅仅在定义它的方法或代码块中
            //如果外部类和局部内部类的成员重名时,默认遵循就近原则
            //如果想使用外部类的成员,使用 外部类名.this.成员访问
            private int n1 = 800;
            public void f1() {
                System.out.println("n1 = " + n1 + " 外部类的n1 = " + Outer02.this.n1);
                m2();
            }
        }
        //外部类在方法中,可以创建Inner02对象,然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
    { //代码块
        class Inner03 {

        }
    }
}
