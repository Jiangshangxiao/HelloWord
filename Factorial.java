public class Factorial {

    public static void main(String[] args) {
        Tools myTools = new Tools();
        int n = 9;
        int res = myTools.factorial(n);
        System.out.println(n + "的阶乘为：" + res);
    }
}

class Tools {
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
