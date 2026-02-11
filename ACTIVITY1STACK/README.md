Part A: Conceptual Questions
1. Define Stack and explain LIFO principle

A Stack is a linear data structure in which elements are inserted and removed only from one end, called TOP.
It follows the LIFO principle:
Last In, First Out
The element which is inserted last will be removed first.
Example:
If we push elements: 10 → 20 → 30
Then pop will remove 30 first.

2. What is Stack Overflow and Stack Underflow?
 Stack Overflow
Occurs when we try to push an element into a full stack.
Example:
Stack size = 5
Already has 5 elements
Trying push(60) → Overflow
Stack Underflow
Occurs when we try to pop an element from an empty stack.

Example:
Stack is empty
Trying pop() → Underflow

3. Real-life examples of Stack

Plates stacked in a cafeteria 
– Last plate placed is taken first

Undo operation in text editor
– Last change undone first

Browser history (Back button)
– Last visited page is accessed first

Stack of books

4. Time complexity of Push and Pop operations
Operation  Time Complexity 
 Push      O(1)       
 Pop       O(1)       
 Peek      O(1)

PART B:DRY RUN ACTIVITY 
![WhatsApp Image 2026-02-11 at 15 01 37](https://github.com/user-attachments/assets/f68519e3-8f5f-4b4d-9c2d-39ef3a0dde56)

PARTC: CODING TASK

import java.util.Scanner;
class StackArray {
    int stack[];
    int top;
    int size;
    StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed into stack");
        }
    }
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--] + " popped from stack");
        }
    }
    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StackArray s = new StackArray(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.pop();
        s.push(40);
        s.peek();
    }
}
OUTPUT:

<img width="362" height="119" alt="codeout" src="https://github.com/user-attachments/assets/8f5b3209-0dfa-4a23-b4cb-e8f9dd33f74a" />

Part D: Balanced Parentheses using Stack

import java.util.Stack;

class BalancedParentheses {
    static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

   for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

  char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String expr = "{[()]}";
        if (isBalanced(expr))
            System.out.println("Balanced Expression");
        else
            System.out.println("Not Balanced");
    }
}
OUTPUT:
<img width="304" height="69" alt="image" src="https://github.com/user-attachments/assets/d3968d75-16ac-498f-8d23-689eafc2421f" />
Short Conclusion (5 lines)

Stack is a linear data structure that follows the LIFO principle.
It allows insertion and deletion only at the top.
Push, Pop, and Peek operations work efficiently in O(1) time.
Stacks are widely used in real-life applications like undo operations and expression evaluation.
Understanding stack operations helps in solving many programming problems efficiently.





