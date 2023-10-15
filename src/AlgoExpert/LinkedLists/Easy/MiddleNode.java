package AlgoExpert.LinkedLists.Easy;

// Middle Node
// Difficulty: Easy     Category: Linked Lists

// You're given a Linked List with at least one node. Write a function
// that returns the middle node of the Linked List. If there are two middle
// nodes (i.e. an even length list), your function should return the second
// of these nodes.

// Each LinkedList node has an integer value as well as a next node pointing
// to the next node in the list or to None / null if it's the tail of the list.

public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNod(LinkedList linkedList) {
        LinkedList fastPointer = linkedList;
        LinkedList slowPointer = linkedList;
        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(2);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(4);
        list.next.next.next.next = new LinkedList(5);

        MiddleNode finder = new MiddleNode();
        LinkedList result = finder.middleNod(list);

        System.out.println("Middle Node value: " + result.value);
    }
}

