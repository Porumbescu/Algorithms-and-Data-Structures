package AlgoExpert.Arrays;

import java.util.*;

// Two Number Sum
// Difficulty: easy     Category: Arrays

// Write a function that takes in a non-empty array of distinct integers and an
// integer representing a target sum. If any two numbers in the input array sum
// up to the target sum, the function should return them in an array, in any
// order. If no two numbers sum up to the target sum, the function should return
// an empty array.

// Note that the target sum has to be obtained by summing two different integers
// in the array; you can't add a single integer to itself in order to obtain the
// target sum.

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> numbers = new HashSet<>();
        for(int num : array){
            int complement = targetSum - num;
            if(numbers.contains(complement)){
                return new int[] {complement, num};
            }
            else{
                numbers.add(num);
            }
        }
        return new int[0];
    }

    public static void main (String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        int[] result = twoNumberSum(array, targetSum);
        if(result.length == 0) {
            System.out.println("No two numbers sum up to the target sum.");
        } else {
            System.out.println("Two numbers that sum up to " + targetSum + " are: " + result[0] + " and " + result[1]);
        }
    }
}
