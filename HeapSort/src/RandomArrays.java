import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomArrays {
    Random r = new Random();
    int[][] arrays = new int[r.nextInt(50) + 50][];

    public void create() throws IOException {
        File file = new File("input.txt");
        FileWriter zapis = new FileWriter(file);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new int[r.nextInt(9900) + 100];
            zapis.write(arrays[i].length + " ");
            for (int k = 0; k < arrays[i].length; k++) {
                arrays[i][k] = r.nextInt();
                zapis.write(arrays[i][k] + " ");
            }
            zapis.write("\n");
        }
        zapis.close();
    }
}
