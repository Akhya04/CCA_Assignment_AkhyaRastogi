package Cores;

class PupilRecord {
    String name;
    int m1, m2, m3;

    PupilRecord(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
}

public class InsertionMny {
    public static void main(String[] args) {

        PupilRecord[] students = {
            new PupilRecord("Akhya", 92, 87, 65),
            new PupilRecord("aayushi", 95, 69, 81),
            new PupilRecord("Rohan", 92, 84, 56),
            new PupilRecord("Come", 78, 86, 91),
            new PupilRecord("Aalu", 89, 96, 85),
            new PupilRecord("Frog", 95, 69, 88)
        };

        for (int i = 1; i < students.length; i++) {
            PupilRecord key = students[i];
            int j = i - 1;

            while (j >= 0 && isLower(students[j], key)) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }

        System.out.println("Students sorted by marks:");
        for (PupilRecord s : students) {
            System.out.println(s.name + " -> " + s.m1 + " " + s.m2 + " " + s.m3);
        }
    }

    static boolean isLower(PupilRecord s1, PupilRecord s2) {
        if (s1.m1 < s2.m1) return true;
        if (s1.m1 == s2.m1 && s1.m2 < s2.m2) return true;
        if (s1.m1 == s2.m1 && s1.m2 == s2.m2 && s1.m3 < s2.m3) return true;
        return false;
    }
}