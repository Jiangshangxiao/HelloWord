package com.JSXExercise.homework.homework05;

public class Employee {
    //属性
    private String name;
    private double sal;
    private int salMonth = 12;

    public void printSal() {
        System.out.println(name + " 年工资是: " + (sal * salMonth));
    }

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }
}
