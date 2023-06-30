package com.JSXExercise.homework.homework05;

public class Scientist extends Employee{
    private double bonus;

    @Override
    public void printSal() {
        System.out.println("科学家 " + getName() + " 年工资是: " + (getSal() * getSalMonth() + bonus));
    }

    public Scientist(String name, double sal) {
        super(name, sal);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
