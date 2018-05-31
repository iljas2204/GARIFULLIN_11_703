import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (array[i][j] == 1) {
                    count++;
                }
                if(i == j && array[i][j] == 1){
                    System.out.println("Graph");
                    System.exit(0);
                }
            }
        }

        if (count + 1 == n) {
            int m = 1;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (array[i][j] == 1) {
                        while (i + m < n && j + m < n) {
                            if (array[i][j] == array[i + m][j + m] && array[i][j + m] == 1) {
                                System.out.println("Graph");
                                System.exit(0);
                            } else {
                                m++;
                            }
                        }
                        m = 1;
                    }
                }
            }
            System.out.println("Tree");
        } else {
            System.out.println("Graph");
        }
    }
}
