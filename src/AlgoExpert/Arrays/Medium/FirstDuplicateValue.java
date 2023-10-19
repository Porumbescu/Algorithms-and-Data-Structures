package AlgoExpert.Arrays.Medium;

// First Duplicate Value
// Difficulty: Medium     Category: Arrays

// Given an array of integers between 1 and n, inclusive, where n is the length of the array,
// the function should return the first integer that appears more than once (when reading from left to right).

// In essence, from all integers that might duplicate in the array, the function should return
// the one with the earliest appearance.

// If no integer is repeated in the array, the function should return -1.
public class FirstDuplicateValue {

    public int findFirstDuplicateValue(int[] array) {
        for (int number : array) {
            int absNumber = Math.abs(number);
            if (array[absNumber - 1] < 0) {
                return absNumber;
            }
            array[absNumber - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstDuplicateValue finder = new FirstDuplicateValue();

        // Test case
        int[] testArray = {2, 1, 5, 2, 3, 3, 4};
        System.out.println(finder.findFirstDuplicateValue(testArray));
    }
}
