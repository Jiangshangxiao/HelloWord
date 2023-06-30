import java.util.Scanner;
public class ArrayAdd {
    public static void main(String[] args) {
        //原始数组使用静态分配int[] arr = {1,2,3}
        //增加的元素4，直接放在数组的最后arr = {1,2,3,4}
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {1,2,3};
        do {
            int[] arrNew = new int[arr.length + 1];
            for (int i = 0;i < arr.length;i++) {
                arrNew[i] = arr[i];
            }
            System.out.println("请输入你要添加的数：");
            int addNum = myScanner.nextInt();
            arrNew[arrNew.length - 1] = addNum;
            arr = arrNew;
            for (int i = 0;i < arr.length;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("是否继续添加y/n");
            char key = myScanner.next().charAt(0);
            if (key == 'n') {
                break;
            }
        }while (true);
    }
}
