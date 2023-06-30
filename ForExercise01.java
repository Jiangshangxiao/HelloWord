public class ForExercise01 {
    //编写一个main方法
    public static void main(String[] args) {
        /* 打印如下样式
        0+10=10
        1+9=10
        2+8=10
        3+7=10
        4+6=10
        5+5=10
        6+4=10
        7+3=10
        8+2=10
        9+1=10
        10+0=10
        */
        int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + "+" + (n - i) + "=" + n);
        }
    }
}
