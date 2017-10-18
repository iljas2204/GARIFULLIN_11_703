package ClassWork;

import java.util.Random;
import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        int[] y=new int[n];
        int[] z=new int[n];
        Random r=new Random();
        for (int i=0;i<n;i++){
            a[i]=r.nextInt(100);
        }
        for(int i=1;i<n;i++){
            if (a[i]*a[i-1]<0){
                y[i]=1;
            }
            if (a[i-1]>a[i]){
                z[i]=1;
            }
        }
        for (int i=1;i<n;i++){
            System.out.print(y[i]+", ");
        }
        System.out.println();
        for (int i=1;i<n;i++){
            System.out.print(z[i]+", ");
        }
    }
}
