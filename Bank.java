public class Bank {
    private CheckingAccount accountOne;
    private CheckingAccount accountTwo;
    public Bank() {
        accountOne = new CheckingAccount("zeus", 10);
        accountTwo = new CheckingAccount("Hades", 200);
    }

    public static void main(String[] args) {
        Bank bankOfGods = new Bank();
        System.out.println(bankOfGods.accountOne.name);
        bankOfGods.accountOne.addFunds(5);
        bankOfGods.accountOne.getInfo();
        System.out.println(bankOfGods.accountOne.getBalance());
        bankOfGods.accountOne.setBalance(5000);
        System.out.println(bankOfGods.accountOne.getBalance());
    }
}
