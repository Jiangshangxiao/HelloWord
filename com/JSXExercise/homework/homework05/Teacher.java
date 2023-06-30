package com.JSXExercise.homework.homework05;

public class Teacher extends Employee{
    private int classDay;
    private double classSal;

    public Teacher(String name, double sal) {
        super(name, sal);
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSal() {
        System.out.println("老师 " + getName() + " 年工资是:" + (getSal() * getSalMonth() + classSal * classDay));
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }
}
