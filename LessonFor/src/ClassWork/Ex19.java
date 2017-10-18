package ClassWork;

import java.util.Random;
import java.util.Scanner;

public class Ex19 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),sum=0;
        int[] a=new int[n];
        int[] b=new int[n];
        Random r = new Random();
        for (int i=0;i<n;i++){
            a[i]=r.nextInt(100);
        }
        for (int u=0;u<n;u++){
            b[u]=r.nextInt(100);
        }
        for (int i=0;i<n;i++){
            sum+=a[i]*b[i];
        }
        System.out.println(sum);
    }
}
