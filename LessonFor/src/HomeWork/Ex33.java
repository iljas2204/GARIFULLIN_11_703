package HomeWork;//+
//Массивы 22ж
import java.util.Random;
import java.util.Scanner;

public class Ex33 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random r=new Random();
        int n=scanner.nextInt(),k=0,w=0;
        int [] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=r.nextInt(100);
        }
        a[0]=0;
        for(int i=0;i<n;i++){
            for (int q=2;q<a[i];q++) {
                if (a[i] % q == 0) {
                    k++;
                }
            }
                    if (k > 0) {
                        w++;
                    }
                    k = 0;
            }
        System.out.println(n-w);
    }
}
