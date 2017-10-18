package ClassWork;

import java.util.Random;
import java.util.Scanner;

public class Ex21 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random r= new Random();
        int n=scanner.nextInt();
        int [] a=new int[n];
        int [] b=new int[n];
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(100);
        }
        for(int i=0;i<n;i++){
            b[i]=a[n-i-1];
        }
        for(int i=0;i<n;i++){
            System.out.print(b[i]+", ");
        }
    }
}
