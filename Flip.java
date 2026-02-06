package Cores;

import java.util.Scanner;

public class Flip {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        int[][] a = new int[r][c];

        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                a[i][j] = s.nextInt();

        char k = s.next().charAt(0);

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if (k == 'H') {
                    
                    System.out.print(a[r-1-i][j] + " ");
                } else {
                   
                    System.out.print(a[i][c-1-j] + " ");
                }
            }
            System.out.println();
        }
    }
}


