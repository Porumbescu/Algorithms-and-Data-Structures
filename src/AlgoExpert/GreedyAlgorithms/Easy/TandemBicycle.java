package AlgoExpert.GreedyAlgorithms.Easy;

import java.util.*;

// Tandem Bicycle
// Difficulty: Easy     Category: Greedy Algorithms

// A tandem bicycle is a bicycle that's operated by two people: person A and
// person B. Both people pedal the bicycle, but the person that pedals faster
// dictates the speed of the bicycle. So if person A pedals at a speed of 5,
// and person B pedals at a speed of 4, the tandem bicycle moves at a speed
// of 5 (tandemSpeed = max(speedA, speedB).

// You're given two lists of positive integers: one that contains the speeds of
//  riders wearing red shirts and one that contains the speeds of riders wearing
//  blue shirts. Each rider is represented by a single positive integer, which is
//  the speed that they pedal a tandem bicycle at. Both lists have the same
//  length, meaning that there are as many red-shirt riders as there are
//  blue-shirt riders. Your goal is to pair every rider wearing a red shirt with a
//  rider wearing a blue shirt to operate a tandem bicycle.

//  Write a function that returns the maximum possible total speed or the minimum
//  possible total speed of all the tandem bicycles being ridden based on an
//  input parameter, fastest.

public class TandemBicycle {

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int sum = 0;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if(fastest) {
            for(int i = 0 ; i < redShirtSpeeds.length; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - i - 1]);
            }
        } else {
            for(int i = 0; i < redShirtSpeeds.length; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds1 = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds1 = {3, 6, 7, 2, 1};

        int[] redShirtSpeeds2 = {1, 2, 3, 4, 5};
        int[] blueShirtSpeeds2 = {5, 4, 3, 2, 1};

        System.out.println("Tandem Bicycle speed for set 1 (fastest): " + tandemBicycle(redShirtSpeeds1, blueShirtSpeeds1, true));
        System.out.println("Tandem Bicycle speed for set 2 (slowest): " + tandemBicycle(redShirtSpeeds2, blueShirtSpeeds2, false));
    }
}