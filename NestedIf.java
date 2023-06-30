import java.util.Scanner;
public class NestedIf {
    public static void main(String[] args) {
        Scanner scoreScanner = new Scanner(System.in);
        System.out.println("请输入成绩:");
        double score = scoreScanner.nextDouble();
        if ( score > 8.0) {
            Scanner genderScanner = new Scanner(System.in);
            System.out.println("请输入你的性别：");
            char gender = genderScanner.next().charAt(0);
            if (gender == '男') {
                System.out.println("你被选入男子组了！");
            }else if (gender == '女') {
                System.out.println("你被选入女子组了！");
            }else {
                System.out.println("性别输入有误，请重新输入！");
            }
        } else {
            System.out.println("很抱歉，你被淘汰了！");
        }
    }
}
