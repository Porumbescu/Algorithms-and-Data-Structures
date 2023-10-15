package AlgoExpert.Arrays.Medium;

// Monotonic Array
// Difficulty: Medium     Category: Arrays

// Write a function that takes in an array of integers and returns a boolean
// representing whether the array is monotonic.
// An array is said to be monotonic if its elements, from left to right, are
// entirely non-increasing or entirely non-decreasing.

// Non-increasing elements aren't necessarily exclusively decreasing; they simply
// don't increase. Similarly, non-decreasing elements aren't necessarily
// exclusively increasing; they simply don't decrease.
// Note that empty arrays and arrays of one element are monotonic.

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        if(array.length < 2){
            return true;
        }

        int currMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;

        boolean decreasing = true;
        boolean increasing = true;

        for(int i = 1; i < array.length; i++){
            if(currMin > array[i]){
                currMin = array[i];
            }
            else if(currMax < array[i]){
                currMax = array[i];
            }
            if(array[0] < array[i] || array[i] > currMin){
                decreasing = false;
            }
            if(array[0] > array[i] || array[i] < currMax){
                increasing = false;
            }
        }

        return decreasing || increasing;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 3, 4, 5};
        int[] array2 = {9, 8, 7, 6, 8};
        int[] array3 = {2, 3, 4, 5, 5, 7, 8, 9, 9};

        System.out.println("Is array1 monotonic? " + isMonotonic(array1));
        System.out.println("Is array2 monotonic? " + isMonotonic(array2));
        System.out.println("Is array3 monotonic? " + isMonotonic(array3));
    }
}
