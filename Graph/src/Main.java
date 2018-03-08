import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] graphMatrix = new int[n][m];
        GraphCode graphCode = new GraphCode();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graphMatrix[i][j] = scanner.nextInt();
            }
        }
        graphCode.GraphCode(graphMatrix);
        graphCode.getMI();
        graphCode.insert(2,3);
        graphCode.insert(1,1);
        graphCode.delete(1,1);
        graphCode.modify(2);
        graphCode.GraphCode(3);
        System.out.println();
        graphCode.getMI();
        System.out.println(graphCode.show(1));
    }
}
