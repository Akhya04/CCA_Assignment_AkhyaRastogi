package Cores;
class Node5 {
    String key;
    int value;
    Node5 next;
    Node5(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class MyHashMap {
    private Node5[] table;
    private int size;
    
    public MyHashMap(int capacity){
        table = new Node5[capacity];
        size = capacity;
    }
    // replacement for hashcode()
    public int hash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash = hash + key.charAt(i);
        }
        return hash % size;
    }
    public void put(String key, int value){
        int index = hash(key);
        Node5 newNode = new Node5(key, value);
        // if bucket is empty
        if(table[index] == null){
            table[index] = newNode;
            return;
        }
        Node5 current = table[index];
        while (current != null){
            // if key already exists → update
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            if(current.next == null) break;
            current = current.next;
        }
        // insert new node
        current.next = newNode;
    }
    public Integer get(String key) {
        int index = hash(key);
        Node5 current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // not found
    }
}
public class HashMap1{
    public static void main (String[] args) {
        MyHashMap map = new MyHashMap(10);
        map.put("FB", 100);
        map.put("Ea", 200);
        map.put("A", 10);
        System.out.println(map.get("FB"));  // 100
        System.out.println(map.get("EE"));  // null
        System.out.println(map.get("A"));   // 10
    }
}