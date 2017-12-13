package Ne_sdannoe_ili_ne_proverennoe;
import java.util.Random;
import java.util.Scanner;
//локальный минимум
public class localmin {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int min, x = 0, z;

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100);
            System.out.print(a[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    x = j;
                }
            }
            if (i != x) {
                z = a[i];
                a[i] = min;
                a[x] = z;

            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
