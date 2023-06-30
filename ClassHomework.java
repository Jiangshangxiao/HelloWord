public class ClassHomework {
    public static void main(String[] args) {
        //编写一个类里面有一个max方法，用于找出数组中的最大值
        A01 myA01 = new A01();
        double[] arr = {1,2,3};
        Double res = myA01.max(arr);
        if (res != null) {
            System.out.println("arr的最大值= " + res);
        } else {
            System.out.println("arr的输入有误,数组不能为null,或者为{}");
        }
    }
}

class A01 {
    public Double max(double[] arr) {
        if (arr != null && arr.length > 0) {
            double max = arr[0];
            for (int i = 0;i < arr.length;i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        } else {
            return null;
        }
    }
}
