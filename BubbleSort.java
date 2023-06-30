public class BubbleSort {
    public static void main(String[] args) {
        //将五个无序：24，69，80，57，12
        //使用冒泡排序法将其排成一个从小到大的有序数列
        int[] arr = {24,69,80,57,12};
        int temp = 0;
        for (int i = 0;i < arr.length -1;i++) {
            for (int j = 0;j < arr.length -1;j++ ) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println();
            System.out.println("第" + (i + 1) + "轮排序：");
            for (int k = 0;k < arr.length;k++) {
                System.out.print(arr[k] + " ");
            }
        }
    }
}
