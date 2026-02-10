2. Part 1 – Scenario Based Analysis

Scenario	Choice	Justification & Complexity
1. Real-time chat message storage	LinkedList	Frequent insertions at the end (new messages) and potentially removing old messages from the start. 


Complexity: Insertion $O(1)$.
2. Music playlist (frequently reordered)	LinkedList	Moving songs (nodes) requires changing pointers rather than shifting thousands of elements (as in an Array). 


Complexity: Reordering is $O(1)$ (once node is known).
3. Student database (search by index)	ArrayList	ArrayLists support Random Access (Direct Access). 


Complexity: Access is $O(1)$.
4. Browser back and forward navigation	LinkedList	Specifically a Doubly Linked List (or Stacks). You need to traverse prev and next efficiently. 


Complexity: Navigation is $O(1)$.
5. Online exam (sequential answers)	ArrayList	Answers are stored one after another; memory is contiguous and cache-friendly. 


Complexity: Sequential access is fast; memory overhead is lower.


3. Part 2 – Coding Challenges
Task A – ArrayList Advanced
Objective: Operations on java.util.ArrayList.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListTask {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] input = {12, 45, 7, 22, 89, 2, 33, 60, 15, 10};
        for (int n : input) numbers.add(n);
        System.out.println("Original List: " + numbers);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removing evens: " + numbers);
        if (!numbers.isEmpty()) {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);
            System.out.println("Max: " + max + " | Min: " + min);
            Collections.sort(numbers, Collections.reverseOrder());
            System.out.println("Sorted Descending: " + numbers);
        }
    }
}
Task B – LinkedList Implementation (Using Java Built-in)
Objective: Simulate a Hospital Queue using java.util.LinkedList.
import java.util.LinkedList;

public class HospitalQueue {
    public static void main(String[] args) {
        LinkedList<String> patientQueue = new LinkedList<>();
        patientQueue.add("Patient A");
        patientQueue.add("Patient B");
        patientQueue.add("Patient C");
        patientQueue.add("Patient D");
        patientQueue.add("Patient E");     
        System.out.println("Initial Queue: " + patientQueue);
        patientQueue.addFirst("EMERGENCY PATIENT");
        System.out.println("After Emergency: " + patientQueue);
        System.out.println("Treated: " + patientQueue.removeFirst());
        System.out.println("Treated: " + patientQueue.removeFirst());
        System.out.println("Remaining Queue: " + patientQueue);
    }
}
3 – Singly Linked List (Interview Level)
This section implements a manual CustomLinkedList without using Java's built-in collections. This covers Part 3 and the Bonus Challenges (Loop detection, Reverse, etc.).
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomLinkedList {
    Node head;
     PART 3 OPERATIONS 
    1. Insert at specific position (0-indexed)
    public void insertAt(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            if (temp == null) return; // Position out of bounds
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    2. Delete by value
    public void deleteByValue(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
     3. Count total nodes
    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
     4. Find Middle Element (Slow & Fast Pointer)
    public int getMiddle() {
        if (head == null) return -1;
        Node slow = head;
        Node fast = head;
           while (fast != null && fast.next != null) {
           slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
     5. Reverse the Linked List
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next; // Save next node
            current.next = prev; // Reverse pointer
            prev = current;      // Move prev one step
            current = next;      // Move current one step
        }
        head = prev;
    }

  PART 5 BONUS CHALLENGES
    public boolean hasLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertAt(10, 0); 
        list.insertAt(20, 1); 
        list.insertAt(30, 2); 
        list.insertAt(15, 1); 
        System.out.print("Current List: ");
        list.display();
        
  System.out.println("Middle Element: " + list.getMiddle());
        System.out.println("Total Nodes: " + list.countNodes());
        
   System.out.println("Reversing List...");
        list.reverse();
        list.display();
    }
}

6. Viva Questions (Answers)
1. What is amortized time complexity?
It is the average time taken per operation over a sequence of operations. For example, in an ArrayList, adding an element is usually $O(1)$. However, when the array is full, it resizes ($O(n)$). When averaged out over many insertions, the "amortized" cost remains $O(1)$.
2. Why is ArrayList resizing expensive?
Arrays require a contiguous block of memory. When an ArrayList fills up, Java cannot just "extend" the memory. It must:
1.	Allocate a new, larger array (usually 1.5x size).
2.	Copy all existing elements from the old array to the new one ($O(n)$ operation).
3.	Garbage collect the old array.
3. How does LinkedList store elements internally?
It uses Nodes. Each node is an object containing two parts:
1.	Data: The actual value.
2.	Pointer (Reference): The memory address of the next node in the sequence.
4. Difference between Singly and Doubly Linked List?
•	Singly: Each node has one pointer (next). You can only traverse forward.
•	Doubly: Each node has two pointers (next and prev). You can traverse both forward and backward, but it consumes more memory.
5. What is the space complexity of a LinkedList?
The space complexity is $O(n)$, where $n$ is the number of elements. However, it uses more memory than an ArrayList because every element requires extra memory to store the next pointer (and prev for Doubly Linked Lists).

