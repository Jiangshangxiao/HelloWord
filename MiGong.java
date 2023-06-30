public class MiGong {
    public static void main (String[] args) {
        //老鼠走迷宫游戏
        //1.先创建迷宫,用二维数组表示int[][] map = new int[8][7]
        //2.先规定map数组的元素值：0表示可以走 1表示墙体

        int[][] map = new int[8][7];
        //3.将最上面的一行和最下面的一行，全部设置为1
        for (int i = 0;i < 7;i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //将最左边和最右边的列全部设置为1
        for (int i = 0;i < 8;i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        //打印迷宫
        for (int i = 0;i < map.length;i++) {
            for (int j = 0;j < map[i].length;j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        FindWayTool myFindWayTool = new FindWayTool();
        myFindWayTool.findWay(map,1,1);

        System.out.println("============老鼠找到走出迷宫路线===========");
        //打印迷宫
        for (int i = 0;i < map.length;i++) {
            for (int j = 0;j < map[i].length;j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class FindWayTool {
    //1.findWay方法就是专门来找出迷宫的路径
    //2.如果找到,就返回true,否则返回false
    //3.map就是二维数组,即表示迷宫
    //4.i,j就是老鼠的位置j,初始化的位置为(1,1)
    //5.规定map数组的各个值的含义
    //0 表示可以走 1 表示障碍物 2 表示可以走 3 表示走过，但走不通
    //6.当map[6][5] = 2就说明找到通路,就可以结束,否则继续
    //7.当确定老鼠找路策略 下-》右-》上-》左
    public boolean findWay(int[][] map,int i,int j) {
        if (map[6][5] == 2) { //说明已经找到
            return true;
        }else {
            if (map[i][j] == 0) { //当前这个位置为0,说明可以走
                //假定可以走通
                map[i][j] = 2;

                //使用找路策略,来确定该位置是否真的可以走通
                if (findWay(map,i + 1,j)) { //先走下
                    return true;
                } else if (findWay(map, i,j + 1)) { //右
                    return true;
                } else if (findWay(map, i - 1,j)) { //上
                    return true;
                } else if (findWay(map,i, i - 1)) { //左
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { //map[i][j] = 1 ,2 ,3
                return false;
            }
        }
    }
}
