import java.util.ArrayList;
public class List {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("JiangShangXiao");
        students.add("Sam");
        students.add("Alex");
        for (int a = 0; a < students.size(); a = a + 1) {
            System.out.println(students.get(a));
        }
    }
}
