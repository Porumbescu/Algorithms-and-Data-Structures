package AlgoExpert.BinaryTrees;

import java.util.*;

// Branch Sums
// Difficulty: easy     Category: Binary Trees

// Write a function that takes in a Binary Tree and returns a list of its branch
// sums ordered from leftmost branch sum to rightmost branch sum.

// A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
// branch is a path of nodes in a tree that starts at the root node and ends at
// any leaf node.

// Each BinaryTree node has an integer value, a left child node, and a right child
// node. Children nodes can either be BinaryTree nodes themselves or None / null.

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<Integer>();
        calculateSums(root, 0, sums);
        return sums;
    }

    public static void calculateSums(BinaryTree root, int runningSum, List<Integer> sums) {
        if(root == null) return;

        int newRunningSum = runningSum + root.value;
        if(root.left == null && root.right == null) {
            sums.add(newRunningSum);
            return;
        }

        calculateSums(root.left, newRunningSum, sums);
        calculateSums(root.right, newRunningSum, sums);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);

        List<Integer> results = branchSums(tree);
        System.out.println("Branch Sums: " + results);
    }
}
