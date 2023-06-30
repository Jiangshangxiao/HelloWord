package com.JSXExercise.enum_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.Boy;
        Gender2 boy2 = Gender2.Boy;
        System.out.println(boy);
        System.out.println(boy2 == boy);
    }
}

enum Gender2 {
    Boy, Girl;
}