package AlgoExpert.Arrays;

import java.util.*;

// Sorted Squared Array
// Difficulty: easy     Category: Arrays

// Write a function that takes in a non-empty array of integers that are sorted
// in ascending order and returns a new array of the same length with the squares
// of the original integers also sorted in ascending order.

public class SortedSquaredArray {

    public static int[] sortedSquaredArray(int[] array) {
        int[] newArray = new int[array.length];
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        for(int i = array.length - 1; i >= 0; i--) {
            if(Math.abs(array[leftIndex]) > Math.abs(array[rightIndex])) {
                newArray[i] = array[leftIndex] * array[leftIndex];
                leftIndex++;
            } else {
                newArray[i] = array[rightIndex] * array[rightIndex];
                rightIndex--;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {-4, -2, 0, 3, 5};
        int[] squaredArray = sortedSquaredArray(array);

        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Squared and Sorted Array: " + Arrays.toString(squaredArray));
    }
}

