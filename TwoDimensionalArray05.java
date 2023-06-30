public class TwoDimensionalArray05 {
    public static void main(String[] args) {
        //int arr[][] = {{4,6},{1,4,4,7},{-2}};遍历该二维数组，并得到和
        int arr[][] = {{4,6},{1,4,4,7},{-2}};
        int sum = 0;
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0;j < arr[i].length;j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("sum = " + sum);
    }
}
