package Cores;

import java.util.PriorityQueue;
import java.util.Random;

// Renamed 'Node110' to 'BSTNode'
class BSTNode {
    int key;
    BSTNode left, right;
    public BSTNode(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    BSTNode root;
    // Task 1: Insert Operation
    void insert(int key) {
        root = insertRec(root, key);
    }
    BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
    // Task 2: Traversals
    void inorder() {
        System.out.print("Inorder: ");
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    void preorder() {
        System.out.print("Preorder: ");
        preorderRec(root);
        System.out.println();
    }

   void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

   void postorder() {
        System.out.print("Postorder: ");
        postorderRec(root);
        System.out.println();
    }

   void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

   // Task 3: Search Operation
    boolean search(int key) {
        return searchRec(root, key);
    }

  boolean searchRec(BSTNode root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        return root.key > key ? searchRec(root.left, key) : searchRec(root.right, key);
    }
}

public class Activity1_Trees_Heaps {
    public static void main(String[] args) {
        // --- BST SECTION ---
        BinarySearchTree tree = new BinarySearchTree();
    // Task 1: Insert elements 50, 30, 70, 20, 40, 60, 80
        int[] elements = {50, 30, 70, 20, 40, 60, 80};
        System.out.println("--- Task 1: Inserting Elements ---");
        for (int el : elements) {
            tree.insert(el);
            System.out.print(el + " ");
        }
        System.out.println("\n");

   // Task 2: Perform Traversals
        System.out.println("--- Task 2: Traversals ---");
        tree.inorder();
        tree.preorder();
        tree.postorder();
        System.out.println();

   // Task 3: Search for 40 and 100
        System.out.println("--- Task 3: Search Results ---");
        int[] searchTargets = {40, 100};
        for (int target : searchTargets) {
            boolean found = tree.search(target);
            System.out.println("Element " + target + (found ? " Found" : " Not Found"));
        }
        System.out.println();
    // --- HEAP SECTION ---
        // Task 4: Implement Min-Heap using Java PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  // Task 5: Insert 10 random numbers and print in sorted order
        System.out.println("--- Task 4 & 5: Min-Heap Operations ---");
        Random rand = new Random();
        System.out.print("Inserting random numbers: ");
        
  for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100); 
            minHeap.add(num);
            System.out.print(num + " ");
        }
        System.out.println("\n\nSorted Order (extracted from Min-Heap):");
        
   while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }
}
OUTPUT


<img width="398" height="239" alt="Screenshot 2026-02-16 112651" src="https://github.com/user-attachments/assets/3bb5008e-bb99-452c-883d-40959bd07824" />

Binary Search Tree (BST)
Elements Inserted:

50, 30, 70, 20, 40, 60, 80

BST Structure:
        50
       /  \
     30    70
    /  \   /  \
  20   40 60   80

 Operations Performed
1. Insert

Elements are inserted following BST property:

Left child < Root

Right child > Root

2. Traversals

Inorder (LNR):
20 30 40 50 60 70 80

Preorder (NLR):
50 30 20 40 70 60 80

Postorder (LRN):
20 40 30 60 80 70 50

3. Search

Search 40 → Found
Search 100 → Not Found

 Min-Heap (PriorityQueue)

Implemented using Java PriorityQueue

Inserted 10 random numbers

Printed in sorted (ascending) order

Example Output:
1 3 10 12 25 34 45 56 78 89
Time Complexity Analysis
BST

Insert → O(log n) average, O(n) worst
Search → O(log n) average, O(n) worst
Traversal → O(n)

Worst case occurs when tree becomes skewed.

Min-Heap

Insert → O(log n)
Remove → O(log n)
Peek → O(1)
