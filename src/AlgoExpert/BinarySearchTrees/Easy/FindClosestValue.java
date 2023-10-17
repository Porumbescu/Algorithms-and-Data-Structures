package AlgoExpert.BinarySearchTrees.Easy;

// Find Closest Value
// Difficulty: Easy     Category: Binary Search Trees

//  Write a function that takes in a Binary Search Tree (BST) and a target integer
//  value and returns the closest value to that target value contained in the BST.

// You can assume that there will only be one closest value.

// Each BST node has an Integer value, a left child node, and a right child node.
// A node is said to be a valid BST node if and only if it satisfies the BST
// property: its value is strictly greater than the value of every node to its
// left; its value is less than or equal to the values of every node to its right;
// and its children nodes are either valid BST nodes themselves or None / null.
public class FindClosestValue {

    public static int findClosestValueInBst(BST tree, int target) {
        int closest = tree.value;
        while(tree != null){
            if(Math.abs(target - closest) > Math.abs(target - tree.value)){
                closest = tree.value;
            }
            if(target > tree.value && tree.right != null){
                tree = tree.right;
            }
            else if(target < tree.value && tree.left != null){
                tree = tree.left;
            }
            else break;
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        System.out.println("Closest value to 12: " + findClosestValueInBst(root, 12));
        System.out.println("Closest value to 17: " + findClosestValueInBst(root, 17));
    }
}

