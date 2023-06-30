public class ArrayReverse {
    public static void main(String[] args) {
        //把arr = {11,22,33,44,55,66}翻转成 {66,55,44,33,22,11}
        int[] arr = {11,22,33,44,55,66};
        int temp = 0;
        int len = arr.length;
        for (int i = 0;i < len / 2;i++) {
            temp = arr[len - 1 - i];
            arr[len - 1 - i] = arr[i];
            arr[i] = temp;
        }
        for (int j = 0;j < arr.length;j++) {
            System.out.print(arr[j] + ",");
        }
    }
}
