public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = new int[arr1.length];
        for (int i = 0;i < arr2.length;i++) {
            arr2[i] = arr1[i];
        }
        for (int j = 0;j < arr2.length;j++) {
            System.out.println(arr2[j]);
        }
    }
}
