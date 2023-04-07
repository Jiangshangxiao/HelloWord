public class SavingsAccount {
    int balance;

    public SavingsAccount(int initialBalance) {
        balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Hello");
        System.out.println("Your balance is " + balance);
    }

    public void deposit(int amountToDeposit) {
        int newBalance = amountToDeposit + balance;
        balance = newBalance;
        System.out.println("You just deposited amountToDeposit " + amountToDeposit);
    }

    public int withdraw(int amountToWithdraw) {
        int newBalance = balance - amountToWithdraw;
        balance = newBalance;
        System.out.println("You just withdraw amountToWithdraw " + amountToWithdraw);
        return amountToWithdraw;
    }

    public static void main(String[] args) {
        SavingsAccount saving = new SavingsAccount(2000);

        //check balance
        saving.checkBalance();

        //deposit
        saving.deposit(1000);
        saving.checkBalance();

        //withdraw
        saving.withdraw(500);
        saving.checkBalance();

    }
}
