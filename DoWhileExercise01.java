import java.util.Scanner;
public class DoWhileExercise01 {
    //编写一个main方法
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        char answer = ' ';
        do {
            System.out.println("老韩使出闪电五连鞭！");
            System.out.println("老韩问：还钱吗：？y/n");
            answer = myScanner.next().charAt(0);
        } while (answer != 'y');
    }
}
