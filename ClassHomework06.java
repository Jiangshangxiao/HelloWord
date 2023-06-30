public class ClassHomework06 {
    int count = 9;
    public void count1() {
        count = 10;
        System.out.println("count1 = " + count);
    }

    public void count2() {
        System.out.println("count = " + count++);
    }
    public static void main(String[] args) {
        new ClassHomework06().count1();
        ClassHomework06 myClassHomework06 = new ClassHomework06();
        myClassHomework06.count2();
        myClassHomework06.count2();
    }
}
