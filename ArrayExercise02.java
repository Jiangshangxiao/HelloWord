public class ArrayExercise02 {
    public static void main(String[] args) {
        //请求出一个数组int[]的最大值{4,-1,10,20}，并得到对应的下标
        int[] arr = {4,-1,10,20,100,101,50};
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1;i < arr.length;i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("max = " + max + " maxIndex = " + maxIndex);
    }
}
