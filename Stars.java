public class Stars {
    //编写一个main方法
    public static void main(String[] args) {
        //打印空心金字塔
        for (int i = 1;i <= 5;i++) {
            for (int k = 1; k <= 5-i;k++) {
                System.out.print(" ");
            }
            for (int j = 1;j <= i * 2 - 1;j++) {
                if (j == 1 || j == i * 2 - 1 || i == 5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
