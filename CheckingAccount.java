public class CheckingAccount {
    public String name;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public CheckingAccount(String inputName, int inputBalance) {
        name = inputName;
        balance = inputBalance;
    }

    public void addFunds(int fundsToAdd) {
        balance += fundsToAdd;
    }

    public void getInfo() {
        System.out.println("This checking account belongs to " + name + ". It has " + balance + " dollars in it.");
    }

    public static void main(String[] args) {
        CheckingAccount myAccount = new CheckingAccount("JiangShangXiao", 2000);
        System.out.println(myAccount.balance);
        myAccount.addFunds(5);
        System.out.println(myAccount.balance);
    }
}
