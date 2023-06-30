public class ATM {
    public static int totalMoney = 0;
    public static int numATM = 0;
    public int money;

    public ATM(int inputMoney) {
        this.money = inputMoney;
        numATM += 1;
        totalMoney += inputMoney;
    }

    public void withdrawMoney(int amountToWithdraw) {
        if(amountToWithdraw <= this.money) {
            this.money -= amountToWithdraw;
            totalMoney -= amountToWithdraw;
        }

    }

    public static void averageMoney() {
        System.out.println("averageMoney: " + totalMoney / numATM);
    }

    public static void main(String[] args) {
        System.out.println("Total number of ATMs: " + ATM.numATM);
        ATM firstATM = new ATM(1000);
        ATM secondATM = new ATM(500);
        System.out.println("Total number of ATMs " + ATM.numATM );

        System.out.println(" amount of money in firstATMs: " + firstATM.money);
        System.out.println(" amount of money in secondATMs: " + secondATM.money);

        System.out.println(ATM.totalMoney);
        System.out.println(firstATM.totalMoney);
        System.out.println(secondATM.totalMoney);

        System.out.println("Total amount of money in all ATMs: " + ATM.totalMoney);

        ATM.averageMoney();
    }
}
