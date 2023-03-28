public class TestSwitchCase {
    public static void main(String[] args) {
        char grade = 'C';
        switch(grade)
        {
            case 'A':
                System.out.println("你的成绩是优秀");
            case 'B':
            case 'C':
                System.out.println("你的成绩是及格");
                break;
            default:
                System.out.println("未知成绩");
        }
    }
}
