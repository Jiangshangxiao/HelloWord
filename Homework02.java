public class Homework02 {
    //编写一个main方法
    public static void main(String[] args) {
        //判断一个整数是否是一个水仙花数
        int n = 153;
        int n1 = n / 100;
        int n2 = n % 100 / 10;
        int n3 = n % 10;
        if (n1 * n1 * n1 + n2 * n2 * n2 + n3 * n3 * n3 == n) {
            System.out.println(n + "是水仙花数");
        } else {
            System.out.println(n + "不是水仙花数");
        }
    }
}
