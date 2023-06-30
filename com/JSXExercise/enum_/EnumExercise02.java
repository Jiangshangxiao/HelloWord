package com.JSXExercise.enum_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class EnumExercise02 {
    public static void main(String[] args) {
        //获取到所有的枚举对象
        Week[] values = Week.values();
        //遍历,使用增强for
        System.out.println("所有星期信息如下：");
        for (Week week : values) {
            System.out.println(week);
        }
    }
}

/*
声明Week枚举类,其中包含星期一至星期天的定义:
MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
使用values 返回所有的枚举数组,并遍历,
 */
enum Week {
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),
    THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),
    SUNDAY("星期日");
    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Week{" +
                "name='" + name + '\'' +
                '}';
    }
}