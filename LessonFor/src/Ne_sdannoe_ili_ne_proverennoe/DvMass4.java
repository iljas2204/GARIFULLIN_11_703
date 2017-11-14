package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;
//задача 4 двумерные массивы
public class DvMass4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, n = scanner.nextInt(), m = scanner.nextInt();
        if (n >= m) {
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {  //какой смысл здесь гнать цикл до конца, если дальше идет выбраковка?
                    if (i <j) {
                        x = a[i][j];
                        a[i][j] = a[j][i];
                        a[j][i] = x;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        if (n < m) {
            int[][] a = new int[m][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i < j) {
                        x = a[i][j];
                        a[i][j] = a[j][i];
                        a[j][i] = x;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
