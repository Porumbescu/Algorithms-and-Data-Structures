package AlgoExpert.GreedyAlgorithms.Easy;

import java.util.*;

// Minimum Waiting Time
// Difficulty: Easy     Category: Greedy Algorithms

//  You're given a non-empty array of positive integers representing the amounts
//  of time that specific queries take to execute. Only one query can be executed
//  at a time, but the queries can be executed in any order.

//  A query's waiting time is defined as the amount of time that it must
//  wait before its execution starts. In other words, if a query is executed
//  second, then its waiting time is the duration of the first query; if a query
//  is executed third, then its waiting time is the sum of the durations of the
//  first two queries.

// Write a function that returns the minimum amount of total waiting time for all
// the queries. For example, if you're given the queries of durations [1, 4, 5],
// then the total waiting time if the queries were executed in the order of
// [5, 1, 4] would be (0) + (5) + (5 + 1) = 11.

public class MinimumWaitingTime {

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = 0;
        int sumTotal = 0;
        for(int i = 0; i < queries.length - 1; i++){
            sum += queries[i];
            sumTotal += sum;
        }
        return sumTotal;
    }

    public static void main(String[] args) {
        int[] queries1 = {3, 2, 1, 2, 6};
        int[] queries2 = {1, 4, 5, 2, 3};

        System.out.println("Minimum waiting time for queries1: " + minimumWaitingTime(queries1));
        System.out.println("Minimum waiting time for queries2: " + minimumWaitingTime(queries2));
    }
}
