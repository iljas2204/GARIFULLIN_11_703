import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Array randomArray = new Array();
        int [] array = randomArray.randomArray();
        int summOfArray=0;
        for (int i = 0; i < array.length; i++) {
            summOfArray += array[i];
        }
        System.out.println(summOfArray);
        int numberOfStreams = scanner.nextInt();
        summOfArray = 0;
        int modOfArray = array.length % numberOfStreams;
        int collect = 0;
        for (int i = 0; i < numberOfStreams; i++) {
            SomeThread someThread = new SomeThread(array);
            if(modOfArray != 0) {
                collect += array.length / numberOfStreams + 1;
                someThread.secondNum = collect;
                modOfArray--;
            }
            else {
                collect+= array.length / numberOfStreams;
                someThread.secondNum = collect;
            }
            someThread.start();
            someThread.join();
            summOfArray += someThread.summArr;
        }
        System.out.println(summOfArray);

    }
}
