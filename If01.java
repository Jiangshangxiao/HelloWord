import java.util.Scanner; //导入扫描器包
public class If01 {
    //创建一个main方法
    public static void main(String[] args) {
        //实例化一个Scanner对象
        System.out.println("请输入你的年龄：");
        Scanner myScanner = new Scanner(System.in);

        int age = myScanner.nextInt();
        if (age > 18) {
            System.out.println("你的年龄已经超过18岁，你的为你的行为负责！");
        }
        System.out.println("程序继续。。。");
    }
}
