package Cores;

class MyArrayList1<T extends Comparable<T>> {
    private Object[] data;
    private int size;
    public MyArrayList1() {
        data = new Object[4];
        size = 0;
    }
    public void add(T value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }
    public int search(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                T a = (T) data[j];
                T b = (T) data[j + 1];
                if (a.compareTo(b) > 0) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
    }
}
public class ArrayList2{
    public static void main(String[] args) {
        MyArrayList1<Integer> list = new MyArrayList1<>();
        list.add(10);
		list.add(20);
		list.add(80);
		list.add(40);
		list.add(90);
		list.add(60);
        list.print();
        System.out.println(list.get(4));
        list.remove(2);
        list.print();
        list.sort();
        list.print();
        System.out.println(list.search(40));
    }
}