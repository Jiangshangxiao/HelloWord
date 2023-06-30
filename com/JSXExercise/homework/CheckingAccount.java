package com.JSXExercise.homework;

/**
 * 在上面类的基础上扩展新类CheckingAccount对每次存款和去款都收取1美元手续费
 */
public class CheckingAccount extends BankAccount{
    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
