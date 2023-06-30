public class BreakExercise {
    //编写一个main方法
    public static void main(String[] args) {
        //1-100已被的数求和，求出当和第一次大于20的当前数
        int sum = 0;
        int i = 1;
        for (;i < 100;i++) {
            sum += i;
            if (sum > 20) {
                System.out.println("和大于20，总和sum = " + sum);
                break;
            }
        }
        System.out.println("当前的i值为：" + i);
    }
}
