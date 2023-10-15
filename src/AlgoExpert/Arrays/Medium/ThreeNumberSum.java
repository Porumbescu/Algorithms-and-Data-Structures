package AlgoExpert.Arrays.Medium;

import java.util.*;

// Three Number Sum
// Difficulty: Medium     Category: Arrays

//Write a function that takes in a non-empty array of distinct integers and an
// integer representing a target sum. The function should find all triplets in
// the array that sum up to the target sum and return a two-dimensional array of
// all these triplets. The numbers in each triplet should be ordered in ascending
// order, and the triplets themselves should be ordered in ascending order with
// respect to the numbers they hold.

// If no three numbers sum up to the target sum, the function should return an
// empty array.

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> solution = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            int leftPointer = i + 1;
            int rightPointer = array.length - 1;
            while(leftPointer < rightPointer) {
                if(array[i] + array[leftPointer] + array[rightPointer] == targetSum) {
                    solution.add(new Integer[]{array[i], array[leftPointer], array[rightPointer]});
                    leftPointer++;
                    rightPointer--;
                } else if(array[i] + array[leftPointer] + array[rightPointer] < targetSum) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;

        List<Integer[]> results = threeNumberSum(array, targetSum);
        for(Integer[] triplet : results) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}

