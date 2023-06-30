public class TestPerson {
    public static void main(String[] args) {
        Person1 p = new Person1("JiangShangXiao", 27);
        Person1 p1 = new Person1("JiangShangZhao", 27);
        System.out.println("p与p1比较的结果是" + p.compareTo(p1));
    }
}

class Person1 {
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person1 p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}
