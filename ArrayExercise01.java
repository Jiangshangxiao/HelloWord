public class ArrayExercise01 {
    //编写一个main方法
    public static void main(String[] args) {
        //创建一个char类型的26个元素的数组，分别放置'A'-'z'
        //使用for循环访问所有元素并打印出来。
        char[] chars = new char[26];

        //循环输入'A'-'Z'
        for (int i = 0;i < chars.length;i++) {
            chars[i] = (char) ('A' + i);
        }

        //循环访问数组
        for (int j = 0;j < chars.length;j++) {
            System.out.print(chars[j] + " ");
        }
    }
}
