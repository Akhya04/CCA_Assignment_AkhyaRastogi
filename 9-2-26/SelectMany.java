package Cores;


class Personss {
    String name;
    int m1, m2, m3;

    Personss(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
}

public class SelectMany {
    public static void main(String[] args) {

        Personss[] students = {
            new Personss("Akhya", 92, 87, 65),
            new Personss("aayushi", 95, 69, 81),
            new Personss("Rohan", 92, 84, 56),
            new Personss("Come", 78, 86, 91),
            new Personss("Aalu", 89, 96, 85),
            new Personss("Frog", 95, 69, 88)
        };

        for (int i = 0; i < students.length - 1; i++) {
            
            int maxIdx = i;

            for (int j = i + 1; j < students.length; j++) {
                if (isBetter(students[j], students[maxIdx])) {
                    maxIdx = j;
                }
            }

            Personss temp = students[maxIdx];
            students[maxIdx] = students[i];
            students[i] = temp;
        }

        System.out.println("Students sorted by marks:");
        for (Personss s : students) {
            System.out.println(s.name + " -> " + s.m1 + " " + s.m2 + " " + s.m3);
        }
    }

    static boolean isBetter(Personss s1, Personss s2) {
        if (s1.m1 > s2.m1) return true;
        if (s1.m1 == s2.m1 && s1.m2 > s2.m2) return true;
        if (s1.m1 == s2.m1 && s1.m2 == s2.m2 && s1.m3 > s2.m3) return true;
        return false;
    }
}


