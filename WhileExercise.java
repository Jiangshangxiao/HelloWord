public class WhileExercise {
    //编写一个main方法
    public static void main(String[] args) {
        //打印40-200之间的所有偶数
        int i = 40;
        int end = 200;
        while (i <= end) {
            if (i % 2 == 0) {
                System.out.println("i = " + i);
            }
            i++;
        }

    }

}
