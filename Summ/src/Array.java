import java.util.Random;

public class Array {
    public int [] randomArray(){
        Random random = new Random();
        int [] array = new int[1000000];
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(500) + 501;
        }
        return array;
    }
}
