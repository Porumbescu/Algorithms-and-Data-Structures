package AlgoExpert.BinaryTrees.Easy;

import java.util.*;

// Node Depths
// Difficulty: Easy     Category: Binary Trees

// The distance between a node in a Binary Tree and the tree's root is called the node's depth.

// Write a function that takes in a Binary Tree and returns the sum of its nodes' depths.

// Each BinaryTree node has an integer value, a left child node, and a right child
// node. Children nodes can either be BinaryTree nodes themselves or None / null.
public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        return calculateDepth(root, 0);
    }

    public static int calculateDepth(BinaryTree root, int depth){
        if(root == null) return 0;
        return depth + calculateDepth(root.left, depth + 1) + calculateDepth(root.right, depth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println("Node Depths: " + nodeDepths(root));
    }
}