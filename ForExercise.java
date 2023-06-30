public class ForExercise {
    //编写一个main方法
    public static void main(String[] args) {
        //打印1~100之间所有是9得倍数的整数，统计个数及总和
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 9 == 0) {
                System.out.println("i = " + i);
                count++;
                sum += i;
            }
        }
        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
    }
}
