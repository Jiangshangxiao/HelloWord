public class MethodExercise {
    public static void main(String[] args) {
        AA myAA = new AA();
        myAA.print(4,4,'#');
        if (myAA.isOod(3)) {
            System.out.println("3是一个奇数");
        }
    }
}

class AA {
    public void print(int row, int col,char c) {
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                System.out.print(c + "");
            }
            System.out.println();
        }
    }

    public boolean isOod(int num) {
        return num % 2 != 0 ? true : false;
    }
}
