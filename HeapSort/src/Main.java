import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomArrays randomArrays = new RandomArrays();
        randomArrays.create();
        Scanner scanner = new Scanner(new FileReader("input.txt"));
        for (int j = 0; j < randomArrays.arrays.length ; j++) {
            int[] array = new int[scanner.nextInt()];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            HeapSortAlgorithm sortAlgorithm = new HeapSortAlgorithm();
            sortAlgorithm.sort(array);
            System.out.println(array.length);
        }
    }
}
