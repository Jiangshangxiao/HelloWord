public class Homework07 {
    //编写一个main方法
    public static void main(String[] args) {
        //输出小写的a-z以及大写的Z-A

        //小写a-z
        for (char c1 = 'a'; c1 <= 'z';c1++) {
            System.out.print(c1 + " ");
        }
        System.out.println();
        System.out.println("======================");
        //大写A-Z
        for (char c2 = 'Z';c2 >= 'A';c2--) {
            System.out.print(c2 + " ");
        }
    }
}
