package Cores;
import java.util.*;

class People{
    String name;
    int id;

    public People(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }
}

public class BubbleObject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of students:");
        int n = sc.nextInt();
        
        People[] stu = new People[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println("Enter ID for student " + (i+1) + ":");
            int id = sc.nextInt();
            System.out.println("Enter Name for student " + (i+1) + ":");
            String name = sc.next();
            stu[i] = new People(name, id);
        }

       
        for(int i = 0; i < n - 1; i++) {
            
           
            for(int j = 0; j < n - 1 - i; j++) {
                
                if(stu[j].id > stu[j+1].id) {
                    People temp = stu[j];
                    stu[j] = stu[j+1];
                    stu[j+1] = temp;
                }
            }
        }

        
        System.out.println("Sorted List:");
        System.out.println(Arrays.toString(stu));
        
       
    }
}