package com.JSXExercise.object;

public class ToString_ {
    public static void main(String[] args) {
        Monster monster = new Monster("monster", "work", 1000);
        System.out.println(monster.toString());
    }
}
class Monster {
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    //重写toString方法,输出对象的属性

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
