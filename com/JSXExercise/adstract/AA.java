package com.JSXExercise.adstract;

public class AA extends Template{

    @Override
    public void job() { //实现Template的抽象方法job
        long num = 0;
        for (int i = 1; i <= 800000; i++) {
            num += i;
        }
    }
}
