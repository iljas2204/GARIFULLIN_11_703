package HomeWork;
import java.util.Scanner;
// номер 10г , стр 22
public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, x;
        double p = 1, s = 0;
        n = scanner.nextInt();
        x = scanner.nextInt();
        if (n % 2 == 0) {
            for (int k = 1; k <= 2 * n; k++) {
                p = p * x / (k + k);
                s = s + p;
            }
        }
        else {
                for (int k = 1; k <= 2 * n; k++) {
                    p = p * x / (k + k - 1);
                    s = s + p;
                }
            }
            System.out.println(s);
        }
    }
