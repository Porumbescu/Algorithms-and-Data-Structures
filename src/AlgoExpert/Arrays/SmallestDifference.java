package AlgoExpert.Arrays;

import java.util.*;

// Smallest Difference
// Difficulty: Medium     Category: Arrays

// Write a function that takes in two non-empty arrays of integers, finds the
// pair of numbers (one from each array) whose absolute difference is closest to
// zero, and returns an array containing these two numbers, with the number from
// the first array in the first position.

// Note that the absolute difference of two integers is the distance between
// them on the real number line. For example, the absolute difference of -5 and 5
// is 10, and the absolute difference of -5 and -4 is 1.

// You can assume that there will only be one pair of numbers with the smallest
// difference.

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int minAbs = Integer.MAX_VALUE;
        int val1 = 0;
        int val2 = 0;

        int p1 = 0;
        int p2 = 0;

        while (p1 < arrayOne.length && p2 < arrayTwo.length) {
            int currentDiff = Math.abs(arrayOne[p1] - arrayTwo[p2]);

            if (currentDiff < minAbs) {
                minAbs = currentDiff;
                val1 = arrayOne[p1];
                val2 = arrayTwo[p2];
            }

            if(arrayOne[p1] < arrayTwo[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }

        return new int[] {val1, val2};
    }

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        int[] result = smallestDifference(arrayOne, arrayTwo);
        System.out.println("The two numbers with the smallest difference are: " + result[0] + " and " + result[1]);
    }
}

