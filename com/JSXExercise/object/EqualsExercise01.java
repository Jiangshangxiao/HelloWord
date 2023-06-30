package com.JSXExercise.object;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person_ person = new Person_();
        person.name = "hspedu";

        Person_ person1 = new Person_();
        person1.name = "hspedu";

        System.out.println(person == person1);
        System.out.println(person.name.equals(person1.name));
        System.out.println(person.equals(person1));

        String s1 = new String("s1");

        String s11 = new String("s1");
        System.out.println(s1.equals(s11));
        System.out.println(s1 == s11);
    }
}
class Person_ {
    public String name;
}
