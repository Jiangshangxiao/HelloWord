package com.JSXExercise.homework;

/**
 * 扩展前一个BankAccount类
 * 新类SavingAccount类每个月都有利息产生(earnMonthlyInterest方法别调用)
 * 并且有每月三次免手续费的存款或取款.在earnMonthlyInterest方法中重置交易计数
 */
public class SavingAccount extends BankAccount{
    private int count = 3;
    private double rate = 0.01; //利率

    public void earnMonthlyInterest() { //每个月初,统计上个月的利息
        count = 3;
        super.deposit(getBalance() * rate);
    }

    @Override
    public void deposit(double amount) {
        //判断是否还可以免手续费
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        //判断是否还可以免手续费
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }

    public SavingAccount(double balance) {
        super(balance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
