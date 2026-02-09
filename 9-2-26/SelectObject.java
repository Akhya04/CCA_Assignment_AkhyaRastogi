package Cores;


import java.util.*;

class Person{
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }
}

public class SelectObject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of students:");
        int n = sc.nextInt();
        
        Person[] stu = new Person[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println("Enter ID for student " + (i+1) + ":");
            int id = sc.nextInt();
            System.out.println("Enter Name for student " + (i+1) + ":");
            String name = sc.next();
            stu[i] = new Person(name, id);
        }

       
        for (int i = 0; i < n - 1; i++) {
           
            int min_idx = i;
            
           
            for (int j = i + 1; j < n; j++) {
                if (stu[j].id < stu[min_idx].id) {
                    min_idx = j;
                }
            }

           
            Person temp = stu[min_idx];
            stu[min_idx] = stu[i];
            stu[i] = temp;
        }
      

        System.out.println("Sorted List:");
        System.out.println(Arrays.toString(stu));
        
        sc.close();
    }
}