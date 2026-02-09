package Cores;
import java.util.Scanner;

class AcademicProfile {
    String name;
    int[] marks;

    AcademicProfile(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class InsertionForn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentsCount = sc.nextInt();
        System.out.print("Enter number of subjects: ");
        int subjectsCount = sc.nextInt();
        AcademicProfile[] students = new AcademicProfile[studentsCount];
        for (int i = 0; i < studentsCount; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.next();
            int[] marks = new int[subjectsCount];
            System.out.println("Enter marks:");
            for (int j = 0; j < subjectsCount; j++) {
                marks[j] = sc.nextInt();
            }

            students[i] = new AcademicProfile(name, marks);
        }

        for (int i = 1; i < students.length; i++) {
            AcademicProfile key = students[i];
            int j = i - 1;

            while (j >= 0 && compareMarks(students[j].marks, key.marks) > 0) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }

        System.out.println("\nSorted Students:");
        for (AcademicProfile s : students) {
            System.out.print(s.name + " : ");
            for (int m : s.marks) {
                System.out.print(m + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static int compareMarks(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return b[i] - a[i]; 
            }
        }
        return 0;
    }
}