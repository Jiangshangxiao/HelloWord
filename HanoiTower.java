public class HanoiTower {
    public static void main(String[] args) {
        //汉洛塔游戏
        Tower myTower = new Tower();
        int num = 4;
        myTower.move(num, 'A', 'B', 'C');
    }
}

class Tower {
    //num表示要移动的个数,a ,b ,c分别表示A塔, B塔, C塔
    public void move(int num,char a,char b, char c) {
        if (num == 1) {
            System.out.println(a + "->" + b);
        } else {
            //如果有多个盘,可以看成两个,最下面的和上面的所有盘（num - 1）
            //1.先移动上面所有到b,借助c
            move(num -1,a ,c ,b);
            //2.把最下面这个盘,移动到c
            System.out.println(a + "->" + c);
            //3.再把b塔的所有盘,移动到c,借助a
            move(num - 1,b , a, c);
        }
    }
}