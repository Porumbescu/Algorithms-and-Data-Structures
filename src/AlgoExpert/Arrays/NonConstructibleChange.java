package AlgoExpert.Arrays;

import java.util.*;

// Non-Constructible Change
// Difficulty: Easy     Category: Arrays

// Given an array of positive integers representing the values of coins in your
// possession, write a function that returns the minimum amount of change (the
// minimum sum of money) that you cannot create. The given coins can have
// any positive integer value and aren't necessarily unique (i.e., you can have
// multiple coins of the same value).

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currChange = 0;

        for(int coin : coins) {
            if(coin > currChange + 1) {
                return currChange + 1;
            }
            currChange += coin;
        }

        return currChange + 1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4};

        int result = nonConstructibleChange(coins);
        System.out.println("The smallest change amount that cannot be created is: " + result);
    }
}
