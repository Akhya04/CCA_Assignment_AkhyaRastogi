package Cores;

class Node2<T> {
    T data;
    Node2<T> next;
    Node2(T data) {
        this.data = data;
        this.next = null;
    }
}
class Stack2<T> {
    private Node2<T> top;
    private int size;
    public Stack2() {
        top = null;
        size = 0;
    }
    public void push(T value) {
        Node2<T> newNode = new Node2<>(value);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(value + " pushed to stack");
    }
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow - Cannot pop from empty stack");
        }
        T poppedValue = top.data;
        top = top.next;
        size--;
        return poppedValue;
    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int size() {
        return size;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Node2<T> temp = top;
        System.out.println("Stack elements:");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
public class Stack2Main1{
    public static void main(String[] args) {
        Stack2<Integer> intStack = new Stack2<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();
        System.out.println("Peek: " + intStack.peek());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Size: " + intStack.size());
        intStack.display();
        Stack2<String> strStack = new Stack2<>();
        strStack.push("Apple");
        strStack.push("Banana");
        strStack.push("Cherry");
        strStack.display();
        System.out.println("Peek: " + strStack.peek());
        System.out.println("Pop: " + strStack.pop());
        System.out.println("Size: " + strStack.size());
        strStack.display();
    }
}

