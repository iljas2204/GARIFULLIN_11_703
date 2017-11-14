package Ne_sdannoe_ili_ne_proverennoe;//-

import java.util.Scanner;
//Задача 3 двумерные массивы
public class DvMass3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [][] a=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                a[i][j]=scanner.nextInt();
                if(i<j){    //речь шла о побочной дигонали
                    a[i][j]=1;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
