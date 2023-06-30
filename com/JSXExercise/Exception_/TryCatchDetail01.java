package com.JSXExercise.Exception_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class TryCatchDetail01 {
    public static void main(String[] args) {
        try {
            Person jack = new Person("jack");
            jack = null;
            System.out.println(jack.getName());
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;
        } catch (NullPointerException e) {
            System.out.println("空指针异常=" + e.getMessage());;
        } catch (ArithmeticException e) {
            System.out.println("算术异常=" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}