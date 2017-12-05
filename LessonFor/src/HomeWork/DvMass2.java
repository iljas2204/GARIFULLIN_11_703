package HomeWork;

import java.util.Scanner;
//Задача 2 двумерные массивы
public class DvMass2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [][] a=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i<=j){
                    a[i][j]=scanner.nextInt();
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
