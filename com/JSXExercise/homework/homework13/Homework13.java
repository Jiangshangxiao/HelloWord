package com.JSXExercise.homework.homework13;

public class Homework13 {
    public static void main(String[] args) {
        Student student = new Student("小明", '男', 15, "102");
        student.printInfo();

        System.out.println("--------------------------------");

        Teacher teacher = new Teacher("张飞", '男', 30, 5);
        teacher.printInfo();

        //顶一个多态数组,里面保存2个学生和2个教师,要求按年龄从高到低排序
        Person[] persons = new Person[4];
        persons[0] = new Student("jack", '男', 10, "0001");
        persons[1] = new Student("mary", '女', 20, "0002");
        persons[2] = new Teacher("smith", '男', 36, 5);
        persons[3] = new Teacher("scott", '男', 26, 1);

        //创建对象
        Homework13 homework13 = new Homework13();
        homework13.bubbleSort(persons);

        //输出排序后的数组
        System.out.println("-----排序后的数组-----");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        //遍历数组,调用test方法
        System.out.println("=======================");
        for (int i = 0; i < persons.length; i++) {
            homework13.test(persons[i]);
        }
    }

    //定义方法,形参为Person类型,功能:调用学生的study或教师的teach方法
    public void test(Person p) {
        if (p instanceof Student) {
            ((Student) p).study();
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        }
    }

    //方法,完成年龄从高到低排序
    public void bubbleSort(Person[] person) {
        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - 1 - i; j++) {
                if (person[j].getAge() < person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
    }
}
