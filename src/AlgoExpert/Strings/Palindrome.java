package AlgoExpert.Strings;

// Palindrome
// Difficulty: Easy     Category: Strings

// Write a function that takes in a non-empty string and that returns a boolean
// representing whether the string is a palindrome.

public class Palindrome {

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right) {
            if(!(chars[left] == chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "radar";
        String test2 = "hello";

        System.out.println("Is \"" + test1 + "\" a palindrome? " + isPalindrome(test1));
        System.out.println("Is \"" + test2 + "\" a palindrome? " + isPalindrome(test2));
    }
}
