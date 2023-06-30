import java.util.Scanner;
public class MulForExercise01 {
    //编写一个main方法
    public static void main(String[] args) {
        //统计3个班的成绩情况，每个班又5名学生，求出各个班的平均分和所有班级的平均
        //分【学生的成绩从键盘输入】
        //统计三个班及格人数

        //创建一个Scanner对象
        Scanner myScanner = new Scanner(System.in);
        double totalScore = 0; //累计三个班的总分
        int passNum = 0; //累计三个班及格人数
        for (int i = 1;i <= 3;i++) { //三个班级
            double score = 0; //学生成绩
            double sum = 0; //累计五个学生成绩
            for (int j = 1;j <= 5;j++) { //五个学生
                System.out.println("请输入第" + i + "班级第" + j + "个同学的成绩");
                score = myScanner.nextDouble();
                if (score >= 60) { //判断学生是否及格
                    passNum += 1;
                }
                System.out.println("此位同学的同学的成绩为" + score);
                sum += score;
            }
            System.out.println("第" + i + "班的平均分为" + (sum / 5));
            totalScore += sum;
        }
        System.out.println("三个班的平均分为" + totalScore);
        System.out.println("三个班总共有" + passNum + "及格");
    }
}
