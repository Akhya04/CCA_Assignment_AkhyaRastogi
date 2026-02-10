ACTIVITY 1 – PRACTICAL LEARNING SHEET

2. Part 1 – Concept Analysis 
Feature	ArrayList	LinkedList
Internal Structure	Dynamic array	Doubly linked list
Access Time Complexity	O(1) (index based)	O(n)
Insertion Time Complexity	O(n) (shifting needed)	O(1) at beginning/end
Deletion Time Complexity	O(n)	O(1) if node known
Memory Usage	Less memory	More memory (node + pointers)


3. Part 2 – Coding Task
Task A – ArrayList Program

import java.util.*;
public class ArrayListTask {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(78);
        marks.add(85);
        marks.add(92);
        marks.add(66);
        marks.add(88);
        marks.add(2, 90);
        int min = Collections.min(marks);
        marks.remove(Integer.valueOf(min));
        System.out.println("Final Marks List: " + marks);
    }
}

Task B – LinkedList as Queue

import java.util.*;
public class LinkedListQueue {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Customer1");
        queue.add("Customer2");
        queue.add("Customer3");
        queue.add("Customer4");
        queue.add("Customer5");
        queue.poll();
        queue.poll();
        System.out.println("Remaining Queue: " + queue);
    }
}

4.Part 3 – Singly Linked List Implementation

package Capgg;
class SinglyLinkedList {
    // Node class
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
Node head;
// Insert at Beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
}
  // Insert at End
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
}
   // Traverse
    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
}
// Search
    boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
}
    // Reverse
    void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        System.out.println("Original List:");
        list.traverse();
        System.out.println("Search 30: " + list.search(30));
        System.out.println("Search 50: " + list.search(50));
        list.reverse();
        System.out.println("Reversed List:");
        list.traverse();}}

5. Viva Questions
1. Why is ArrayList access faster?
Because it uses index-based array access (O(1)).
2. Why does LinkedList consume more memory?
Each node stores data + previous + next references.

3. Time complexity of insertion at beginning in SLL?
O(1)

4. Difference between singly and doubly linked list?
Singly: one pointer (next)
Doubly: two pointers (prev & next)
5. What is RandomAccess interface?
Marker interface that allows fast index-based access (used by ArrayList).
