public class ClassHomework04 {
    public static void main(String[] args) {
        //编写一个类A03,实现数组的复制功能copyArr,输入旧数组,返回一个新数组,元素和旧数组一样多
        int[] oldArr = {10,30,50};
        A03 myA03 = new A03();
        int[] newArr = myA03.copyArr(oldArr);
        for (int i = 0;i < newArr.length;i++) {
            System.out.print(newArr[i] + "\t");
        }
    }
}

class A03 {
    public int[] copyArr(int[] oldArr) {
        int[] newArr = new int[oldArr.length];
        for (int i = 0;i < newArr.length;i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }
}
