//导入扫描器包
import java.util.Scanner;
public class Input {
    public static void main(String[] args) {
        //实例化一个扫描器
        Scanner myScanner = new Scanner(System.in);

        //接受用户输入的姓名、年龄、薪水。并打印出来
        System.out.println("请依次输入你的姓名、年龄和薪水");
        System.out.println("你的名字是：");
        String name = myScanner.next();
        System.out.println("你的年龄是：");
        int age = myScanner.nextInt();
        System.out.println("你的薪水是：");
        double salary = myScanner.nextDouble();
        System.out.println("你的名字是：" + name + "年龄是：" + age + "薪水是：" + salary);
    }
}
