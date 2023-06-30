import java.util.Scanner;
public class SwitchExercise {
    public static void main(String[] args) {
        Scanner scoreScanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        double score = scoreScanner.nextDouble();
        if (score >= 0 && score <= 100) {
            switch ((int)score / 60) {
                case 1:
                    System.out.println("成绩合格！");
                    break;
                case 0:
                    System.out.println("成绩不合格！");
                    break;
                default:
            }
        } else {
            System.out.println("输入成绩有误，成绩需要在0~100之间！");
        }
    }
}
