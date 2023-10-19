package AlgoExpert.LinkedLists.Medium;

// Linked List Construction
// Difficulty: Medium     Category: Linked Lists

// You're provided a framework to construct a doubly linked list. The given class
// has methods to set the head, set the tail, insert a node before another node,
// insert a node after another node, insert a node at a specific position,
// remove a node, remove nodes with a specific value, and check if the linked list
// contains a node with a certain value.

// Implement the following methods in the provided DoublyLinkedList class:

// 1. setHead(Node node): This method sets the given node as the head of the linked list.
// 2. setTail(Node node): This method sets the given node as the tail of the linked list.
// 3. insertBefore(Node node, Node nodeToInsert): This method inserts the nodeToInsert before the given node.
// 4. insertAfter(Node node, Node nodeToInsert): This method inserts the nodeToInsert after the given node.
// 5. insertAtPosition(int position, Node nodeToInsert): This method inserts the nodeToInsert at a specific position in the linked list.
// 6. removeNodesWithValue(int value): This method removes all nodes with the given value from the linked list.
// 7. remove(Node node): This method removes the given node from the linked list.
// 8. containsNodeWithValue(int value): This method returns a boolean indicating whether the linked list contains a node with the given value.

// Each Node of the linked list has an integer value, a prev pointer pointing to
// the previous node in the list, and a next pointer pointing to the next node in the list.

// The nodes in the linked list are doubly linked, meaning each node has a pointer
// to both its next node and its previous node.

public class LinkedListConstruction {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(Node node) {
            if (tail == null) {
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            remove(nodeToInsert);
            nodeToInsert.next = node.next;
            nodeToInsert.prev = node;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }

            Node current = head;
            int currentPosition = 1;
            while (current != null && currentPosition++ != position) {
                current = current.next;
            }

            if (current != null) {
                insertBefore(current, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }
        }

        public void removeNodesWithValue(int value) {
            Node current = head;
            while (current != null) {
                Node nodeToRemove = current;
                current = current.next;
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
            }
        }

        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node current = head;
            while (current != null && current.value != value) {
                current = current.next;
            }
            return current != null;
        }
    }

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        dll.setHead(node1);
        dll.setTail(node2);
        dll.insertBefore(node2, node3);

        System.out.println(dll.containsNodeWithValue(3));
    }
}

