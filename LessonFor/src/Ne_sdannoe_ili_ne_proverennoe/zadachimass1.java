package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Random;
import java.util.Scanner;

public class zadachimass1 {
    public static void main(String[] args) {
        //ex1 из отдельного файла

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt(),max;
        int a [][] = new int [n+1][m];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j]=scanner.nextInt();
            }
        }

        max=a[n][0];

        Random random=new Random();
        for (int i = 0; i <m ; i++) {
            do {
                a[n][i]=random.nextInt(50);
            } while (a[n][0]<max);
        }

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
