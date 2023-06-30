public class RecursionExercise {
    public static void main(String[] args) {
        //1.请使用递归的方式求出斐波那契数1,1,2,3,5,8,13...给你一个整数n求出值
        MyTools myTools = new MyTools();
        int n = 8;
        int result = myTools.fibonacci(n);
        if (result == -1) {
            System.out.println("请输入正确的值！");
        } else {
            System.out.println("当n = " + n + "时的斐波那契数为" + result);
        }

        //2.猴子吃桃问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！以后
        //每天猴子都吃其中一半，然后再多吃一个。当到第10天时，想再吃时（即还没有吃），
        //发现只有1个桃子。问题：最初有多少个桃子
        int day = 1;
        int result1 = myTools.peach(day);
        if (result1 == -1) {
            System.out.println("请输入正确的天数！");
        } else {
            System.out.println("第" + day + "天有" + result1 + "个桃子！");
        }
    }
}

class MyTools {
    //求斐波那契数的方法
    public int fibonacci(int n) {
        if ( n > 0) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n - 1) + fibonacci(n -2);
            }
        } else {
            return -1;
        }
    }

    public int peach(int day) {
        if (day == 10) {
            return 1;
        }else if (day >= 1 && day <=9) {
            return (peach(day + 1) + 1) * 2;
        }else {
            return -1;
        }
    }
}
