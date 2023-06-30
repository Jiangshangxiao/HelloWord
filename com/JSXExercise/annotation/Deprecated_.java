package com.JSXExercise.annotation;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
        System.out.println(a.n1);
    }
}

//1.@Deprecated 修饰某个元素,表示该元素已经过时
//2.即不在推荐使用,但是仍然可以使用
@Deprecated
class A {
    @Deprecated
    public int n1 = 10;
    @Deprecated
    public void hi() {

    }
}
