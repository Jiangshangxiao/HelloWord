import java.util.Random;
import java.util.Scanner;

public class MoraGame {
    public static void main(String[] args) {
        //有个人Tom设计他的成员变量,成员方法,可以电脑猜拳
        //电脑每次都会随机生成0,1,2
        //0表示石头 1 表示剪刀 2 表示布
        //并要可以显示Tom的输赢次数

        //创建一个玩家对象
        Tom t = new Tom();
        //用来记录最后输赢的次数
        int isWinCount = 0;

        //创建一个二维数组,用来接收局数,Tom出拳情况以及电脑出拳情况
        int[][] arr1 = new int[3][3];
        int j = 0;

        //创建一个一维数组,用来接受输赢情况
        String[] arr2 = new String[3];

        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < 3;i++) { //比赛三次

            //获取玩家出的拳
            System.out.println("请输入你要出的拳(0拳头， 1剪刀, 2布):");
            int num = myScanner.nextInt();
            t.setTomGuessNum(num);
            int tomGuess = t.getTomGuessNum();
            arr1[i][j + 1] = tomGuess;

            //获取电脑出的拳
            int comGuess = t.computerNum();
            arr1[i][j + 2] = comGuess;

            //将玩家猜的拳与电脑作比较
            String isWin = t.vsComputer();
            arr2[i] = isWin;
            arr1[i][j] = t.count;

            //对每一局的情况进行输出
            System.out.println("==================================================");
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");
            System.out.println(t.count + "\t\t" + tomGuess + "\t\t" + comGuess + "\t\t" + isWin);
            System.out.println("==================================================");
            System.out.println("\n\n");
            isWinCount = t.winCountNum;

            t.updateCount();

        }

        //对游戏的最终结果进行输出
        System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢的情况");
        for (int a = 0; a < arr1.length; a++) {
            for (int b = 0; b < arr1[a].length; b++) {
                System.out.print(arr1[a][b] + "\t\t");
            }
            System.out.print(arr2[a]);
            System.out.println();
        }
    }

}

class Tom {
    //玩家出拳的类型
    int tomGuessNum;
    //电脑出拳的类型
    int comGuessNum;
    //玩家赢的次数
    int winCountNum;
    //比赛的次数
    int count = 1;

    public void updateCount() {
        this.count++;
    }
    //电脑随机生成猜拳的数字的方法
    public int computerNum() {
        Random r = new Random();
        comGuessNum = r.nextInt(3);
        return comGuessNum;
    }

    //设置玩家猜拳的数字方法
    public void setTomGuessNum(int tomGuessNum) {
        if (tomGuessNum > 2 || tomGuessNum < 0) {
            throw new IllegalArgumentException("数字输入有误");
        }
        this.tomGuessNum = tomGuessNum;
    }

    //获得玩家猜拳数字
    public int getTomGuessNum() {
        return tomGuessNum;
    }

    //比较猜拳的结果,玩家赢返回true,否则返回false
    public String vsComputer() {
        if (tomGuessNum == 0 && comGuessNum ==1) {
            winCountNum++;
            return "你赢了";
        } else if (tomGuessNum == 1 && comGuessNum == 2) {
            winCountNum++;
            return "你赢了";
        } else if (tomGuessNum == 2 && comGuessNum == 0) {
            winCountNum++;
            return "你赢了";
        } else if (tomGuessNum == comGuessNum) {
            return "平手";
        } else {
            return "你输了";
        }
    }
}
