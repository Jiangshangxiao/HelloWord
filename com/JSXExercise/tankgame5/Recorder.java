package com.JSXExercise.tankgame5;

import java.io.*;
import java.util.Vector;

/**
 * @author 姜上晓
 * @version 1.0
 * 该类用于记录相关信息,和文件交互
 */
public class Recorder {
    //定义变量,记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    //定义IO对象,准备写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "D:\\myRecord.txt";
    //定义一个Vector, 指向MyPanel对象的敌人坦克
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的Vector,用于保存敌人的信息
    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }
    public static String getRecordFile() {
        return recordFile;
    }
    //增加方法一个方法,用于recordFile,恢复相关信息
    public static Vector<Node> getNodeAndEnemyTankNumRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件,生成nodes集合
            String line = ""; //255 40 0
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),
                         Integer.parseInt(xyd[1]),
                         Integer.parseInt(xyd[2]));
                nodes.add(node); //放入到nodes Vector
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }

    //增加一个方法,当游戏退出时,将allEnemyTankNum保存到recordFile
    //对keepRecord 进行升级,保存敌人坦克的坐标和方向
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "");
            bw.newLine();
            //遍历敌人坦克的vector, 然后根据情况保存即可
            for (int i = 0; i < enemyTanks.size(); i++) {
                //取出敌人坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive) {
                    //保存enemyTank信息
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    //写入到文件
                    bw.write(record + "");
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克,就应当 allEnemyTankNum++
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }
}
