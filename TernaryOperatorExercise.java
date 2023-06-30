public class TernaryOperatorExercise {
    //案例：编写一个main方法
    public static void main(String[] args) {
        //实现得出三个数中的最大值
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;

        //思路
        //1.先得到num1和num2中的最大值，保存到max1中
        //2.然后再求出max1和num3中的最大数，保存到max

        int max1 = num1 > num2 ? num1 : num2;
        int max = max1 > num3 ? max1 : num3;
        System.out.println("最大值： " + max);
    }
}
