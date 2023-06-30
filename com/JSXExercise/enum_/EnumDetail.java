package com.JSXExercise.enum_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSICMUISC.playing();
    }
}

//1.使用enum关键字后,就不能再继承其他类了
//2.enum实现的枚举类,仍然是一个类,所以还是可以实现接口的
interface IPlaying {
    void playing();
}
enum Music implements IPlaying {
    CLASSICMUISC;

    @Override
    public void playing() {
        System.out.println("播放好听的音乐....");
    }
}