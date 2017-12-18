package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

//37 задача из задачника Абрамского

class ex37Abr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] a = new int [n][n];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                a[i][j]=scanner.nextInt();
            }
        }

        for (int i = 0; i <n/2 ; i++) {
            for (int j = i+1; j <n-i-1 ; j++) {
                a[i][j]=0;
            }
        }

        for (int i = n/2+1; i <n ; i++) {
            for (int j = n-i;j<i  ; j++) {
                a[i][j]=0;
            }
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}

