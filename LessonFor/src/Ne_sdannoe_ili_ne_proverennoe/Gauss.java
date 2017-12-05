package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

public class Gauss {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=n+1,c,b;
        int [][]a=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j]= scanner.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                c=a[j][i];
                b=a[i][i];
                for (int k = i; k <m ; k++) {
                    a[i][k] = a[i][k] * c;
                    a[j][k] = a[j][k] * b;
                    a[j][k] = a[j][k] - a[i][k];
                    a[i][k]=a[i][k]/c;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
