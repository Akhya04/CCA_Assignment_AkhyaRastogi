package Cores;
import java.util.*;

class StudentEntry {
    String name;
    int id;

    public StudentEntry(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }
}

public class InsertionObject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of students:");
        int n = sc.nextInt();
        
        StudentEntry[] stu = new StudentEntry[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println("Enter ID for student " + (i+1) + ":");
            int id = sc.nextInt();
            System.out.println("Enter Name for student " + (i+1) + ":");
            String name = sc.next();
            stu[i] = new StudentEntry(name, id);
        }

        for (int i = 1; i < n; i++) {
            StudentEntry key = stu[i];
            int j = i - 1;

            while (j >= 0 && stu[j].id > key.id) {
                stu[j + 1] = stu[j];
                j = j - 1;
            }
            stu[j + 1] = key;
        }

        System.out.println("Sorted List:");
        System.out.println(Arrays.toString(stu));
        
        sc.close();
    }
}