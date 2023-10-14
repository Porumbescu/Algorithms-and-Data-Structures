package AlgoExpert.LinkedLists;

// Remove Duplicates
// Difficulty: Easy     Category: Linked Lists

// You're given the head of a Singly Linked List whose nodes are in sorted order
// with respect to their values. Write a function that returns a modified version
// of the Linked List that doesn't contain any nodes with duplicate values. The
// Linked List should be modified in place (i.e., you shouldn't create a brand-new
// list), and the modified Linked List should still have its nodes sorted
// with respect to their values.

// Each LinkedList node has an integer value as well as a next node pointing
// to the next node in the list or to None / null if it's the tail of the list.

public class RemoveDuplicates {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        if (linkedList == null) {
            return null;
        }

        LinkedList point = linkedList;
        while(point.next != null){
            if(point.value == point.next.value){
                point.next = point.next.next;
            }
            else{
                point = point.next;
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(1);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(3);
        list.next.next.next.next = new LinkedList(3);
        list.next.next.next.next.next = new LinkedList(4);

        RemoveDuplicates remover = new RemoveDuplicates();
        LinkedList result = remover.removeDuplicatesFromLinkedList(list);

        while(result != null) {
            System.out.print(result.value + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}

