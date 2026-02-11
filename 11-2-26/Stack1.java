package Cores;


	class Node {
	    int data;
	    Node next;
	    Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}
	class Stack {
	    Node top;  
	    void push(int value) {
	        Node newNode = new Node(value);
	        newNode.next = top;   
	        top = newNode;       
	        System.out.println(value + ": pushed to stack");
	    }
	    int pop() {
	        if (top==null) {
	            System.out.println("Stack Underflow");
	            return -1;
	        }
	        int popped = top.data;
	        top = top.next; 
	        return popped;
	    }
	    int peek() {
	        if (top==null) {
	            System.out.println("Stack is empty");
	            return -1;
	        }
	        return top.data;
	    }
	    boolean isEmpty() {
	        return top == null;
	    }
	    void display() {
	        Node temp = top;

	        while (temp != null) {
	            System.out.println(temp.data);
	            temp = temp.next;
	        }
	    }
	}
	public class Stack1 {
	    public static void main(String[] args) {
	        Stack s = new Stack();
	        s.push(10);
	        s.push(20);
	        s.push(30);
	        s.display();
	        System.out.println("Peek: " + s.peek());
	        System.out.println("Pop: " + s.pop());
	        s.display();
	    }
	}



