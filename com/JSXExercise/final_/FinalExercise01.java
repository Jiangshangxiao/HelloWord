package com.JSXExercise.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println(circle.calArea());
    }
}

class Circle {
    private double radius;
    private final double PI =  3.14;

    //构造器
    public Circle(double radius) {
        this.radius = radius;
    }

    public double calArea() {
        return PI * radius * radius;
    }
}