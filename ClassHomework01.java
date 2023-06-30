public class ClassHomework01 {
    public static void main(String[] args) {
        //编写类A02,定义方法find,实现查找某字符串是否再字符串数组中
        //并返回索引,如果找到了，就放回下标，如果没找到就返回-1
        A02 myA02 = new A02();
        String[] strs = {"Jack", "Tom", "Rosi"};
        String findStr = "JiangShangXiao";
        System.out.println(myA02.find(findStr, strs));
    }
}

class A02 {
    public int find(String findStr, String[] strs) {
        for (int i = 0;i < strs.length;i++) {
            if (findStr.equals(strs[i])) {
                return i;
            }
        }
        return -1;
    }
}
