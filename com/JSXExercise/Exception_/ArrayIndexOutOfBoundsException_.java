package com.JSXExercise.Exception_;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}