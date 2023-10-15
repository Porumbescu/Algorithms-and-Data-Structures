package AlgoExpert.Arrays.Medium;

import java.util.*;

// Move Element To End
// Difficulty: Medium     Category: Arrays

// You're given an array of integers and an integer. Write a function that moves
// all instances of that integer in the array to the end of the array and returns
// the array.

// The function should perform this in place (i.e., it should mutate the input
// array) and doesn't need to maintain the order of the other integers.

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int p1 = 0;
        int p2 = array.size() - 1;

        while(p1 < p2){
            if(array.get(p1) == toMove && array.get(p2) != toMove){
                int aux = array.get(p2);
                array.set(p2, array.get(p1));
                array.set(p1, aux);
                p1++;
                p2--;
            }
            else if(array.get(p1) == toMove && array.get(p2) == toMove){
                p2--;
            }
            else{
                p1++;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        int toMove = 2;

        List<Integer> result = moveElementToEnd(array, toMove);
        System.out.println("Modified array: " + result);
    }
}
