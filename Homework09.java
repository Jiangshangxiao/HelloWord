public class Homework09 {
    //编写一个main方法
    public static void main(String[] args) {
        //求1+（1+2）+（1+2+3）+....+（1+2+3+....+100）的结果
        int sum = 0;
        for (int i = 1;i <= 100;i++) {
            for (int j = 1;j <= i;j++) {
                sum += j;
            }
        }
        System.out.println("sum = " + sum);
    }
}
