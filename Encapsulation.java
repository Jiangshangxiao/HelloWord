public class Encapsulation {
    public static void main(String[] args) {
        Person01 person01 = new Person01();
        person01.setName("JiangShangXiao");
        person01.setAge(27);
        person01.setSalary(400);
        System.out.println("name = " + person01.getName() + "age = " + person01.getAge() + "salary = " + person01.getSalary());
    }
}

class Person01 {
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名字在2到6个字符之间");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >=0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("年龄在0到100之间");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("薪水要到与0");
        }
    }
}
