package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;
//1 задача массивы двумерные
public class DvMass1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int x,n=scanner.nextInt(),m=scanner.nextInt();
        int [][]a=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                for (int k = 0; k <m-1 ; k++) {
                    if (a[i][k]<a[i][k+1]) {
                        x=a[i][k];
                        a[i][k]=a[i][k+1];
                        a[i][k+1]=x;
                    }
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
