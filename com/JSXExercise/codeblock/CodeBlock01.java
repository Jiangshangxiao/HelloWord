package com.JSXExercise.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("忍者神龟");
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    //不管调用哪个构造器,创建对象,都会先调用代码块的内容
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正式开始...");
    }

    public Movie(String name) {
        this.name = name;
        System.out.println("String name");
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("String name, double price");
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
        System.out.println("String name, double price, String director");
    }
}
