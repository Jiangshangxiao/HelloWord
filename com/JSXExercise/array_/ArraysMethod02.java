package com.JSXExercise.array_;

import java.util.Arrays;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 567};
        int index = Arrays.binarySearch(arr, 90);
        System.out.println("index = " + index);
    }
}
