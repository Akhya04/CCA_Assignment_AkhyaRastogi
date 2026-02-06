package Cores;
import java.util.Scanner;

public class MatrixMultiply{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
     
        int r = s.nextInt();
        int k = s.nextInt();
        int[][] a = new int[r][k];
        for(int i=0; i<r; i++)
            for(int j=0; j<k; j++)
                a[i][j] = s.nextInt();

       
        s.nextInt(); 
        int c = s.nextInt();
        int[][] b = new int[k][c];
        for(int i=0; i<k; i++)
            for(int j=0; j<c; j++)
                b[i][j] = s.nextInt();

       
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                int sum = 0;
                for(int t=0; t<k; t++) {
                    sum += a[i][t] * b[t][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}



