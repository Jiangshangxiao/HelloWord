public class ArrayHomework {
    public static void main(String[] args) {
        //int[] arr = {1,3,4,5,89}插入一个int insertNum = 10，并排序
        //int[] arrNew = {1,3,4,5,10,89}
        int[] arr = {1,3,4,5,89};
        int insertNum = 10;
        int index = -1; //存储下标位置
        for (int i = 0;i < arr.length;i++) { //定位插入的下标
            if (insertNum <= arr[i]) {
                index = i;
            }
        }
        if (index == -1) { //判断插入值是否是最大值
            index = arr.length;
        }
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0,j = 0;i < arrNew.length;i++) { //插入值
            if (i != index) {
                arrNew[i] = arr[j];
                j++;
            } else {
                arrNew[i] = insertNum;
            }
        }
        arr = arrNew;
        for (int i = 0;i < arr.length;i++) { //遍历并打印数组
            System.out.print(arr[i] + "\t");
        }
    }
}
