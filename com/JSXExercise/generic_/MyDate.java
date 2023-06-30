package com.JSXExercise.generic_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) { //把对year-month-day
        //如果name相同,就比较birthday - year
        int yearMius = year - o.getYear();
        if (yearMius != 0) {
            return yearMius;
        }
        //如果year相同,就比较month
        int monthMius = month - o.getMonth();
        if (monthMius != 0) {
            return monthMius;
        }
        //如果year 和 month
        return day - o.getDay();
    }
}
