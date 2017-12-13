package Ne_sdannoe_ili_ne_proverennoe;


import java.util.Random;
import java.util.Scanner;
//локальный максимум
public class localmax {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int max, x = 0, z;

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100);
            System.out.print(a[i] + ", ");
        }

        System.out.println();

        for (int i = a.length - 1; i > 0; i--) {
            max = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] > max) {
                    max = a[j];
                    x = j;
                }
            }
            if(i != x) {
                z = a[i];
                a[i] = max;
                a[x] = z;
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}