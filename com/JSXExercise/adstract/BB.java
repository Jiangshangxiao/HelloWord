package com.JSXExercise.adstract;

public class BB extends Template{
    @Override
    public void job() { //重写Template的job方法
        long num = 0;
        for (int i = 1; i <= 80000; i++) {
            num *= i;
        }
    }
}
