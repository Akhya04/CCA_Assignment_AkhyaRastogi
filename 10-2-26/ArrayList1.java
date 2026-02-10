package Cores;


	import java.util.*;
	//Resizing ArrayList
	class MyArrayList{
		private int[] data;
		private int size;
		public MyArrayList() {
			data=new int[4];
			size=0;
		}
		public void add(int value) {
			if(size==data.length) {
				resize();//TODO:add resize function
			}
			data[size++]=value;
		}
		private void resize() {
			int[] newData=new int[data.length*2];
			for(int i=0;i<data.length;i++) {
				newData[i]=data[i];
			}
			data=newData;
		}
		public void print() {
			for(int i=0;i<data.length;i++) {
				System.out.print(data[i]+" ");
			}
			System.out.println();
		}
		public int get(int index) {
			if(index<0 || index>=size) {
				throw new IndexOutOfBoundsException();
			}
			return data[index];
		}
		public void remove(int index) {
		    if (index < 0 || index >= size) {
		        throw new IndexOutOfBoundsException();
		    }
		    for (int i = index; i < size - 1; i++) {
		        data[i] = data[i + 1];
		    }
		    data[size - 1] = 0;
		    size--;
		}
		public int search(int value) {
		    for (int i = 0; i < size; i++) {
		        if (data[i] == value) {
		            return i;
		        }
		    }
		    return -1;
		}
		public void sort() {
		    for (int i = 0; i < size - 1; i++) {
		        for (int j = 0; j < size - 1 - i; j++) {
		            if (data[j] > data[j + 1]) {
		                int temp = data[j];
		                data[j] = data[j + 1];
		                data[j + 1] = temp;
		            }
		        }
		    }
		}
	}
	public class ArrayList1 {
		public static void main(String[]args) {
			MyArrayList list=new MyArrayList();
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
//			System.out.println(list.get(40));{throw exception}
			list.sort();
			list.print();
			System.out.println(list.search(40));
		}
	}


