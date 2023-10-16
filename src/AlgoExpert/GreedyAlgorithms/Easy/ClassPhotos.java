package AlgoExpert.GreedyAlgorithms.Easy;

import java.util.*;

// Class Photos
// Difficulty: Easy     Category: Greedy Algorithms

// It's photo day at the local school, and you're the photographer assigned to
//  take class photos. The class that you'll be photographing has an even number
//  of students, and all these students are wearing red or blue shirts. In fact,
//  exactly half of the class is wearing red shirts, and the other half is wearing
//  blue shirts. You're responsible for arranging the students in two rows before
//  taking the photo. Each row should contain the same number of the students and
//  should adhere to the following guidelines:

// All students wearing red shirts must be in the same row.
// All students wearing blue shirts must be in the same row.
// Each student in the back row must be strictly taller than the student
// directly in front of them in the front row.

// You're given two input arrays: one containing the heights of all the students
//  with red shirts and another one containing the heights of all the students
//  with blue shirts. These arrays will always have the same length, and each
//  height will be a positive integer. Write a function that returns whether
//  a class photo that follows the stated guidelines can be taken.

public class ClassPhotos {

    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights
    ) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean okRed = true;
        boolean okBlue = true;
        for(int i = 0; i < redShirtHeights.size(); i++){
            if(redShirtHeights.get(i) >= blueShirtHeights.get(i)){
                okRed = false;
            }
            if(redShirtHeights.get(i) <= blueShirtHeights.get(i)){
                okBlue = false;
            }
        }
        return okRed || okBlue;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights1 = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        ArrayList<Integer> blueShirtHeights1 = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));

        ArrayList<Integer> redShirtHeights2 = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights2 = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));

        System.out.println("Is valid photo for set 1: " + classPhotos(redShirtHeights1, blueShirtHeights1));
        System.out.println("Is valid photo for set 2: " + classPhotos(redShirtHeights2, blueShirtHeights2));
    }
}
