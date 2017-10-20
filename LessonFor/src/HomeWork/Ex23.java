package HomeWork;

import java.util.Random;
import java.util.Scanner;
//не решил
public class Ex23 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random r=new Random();
        int n=scanner.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        int[] z=new int[n];
        for(int i=0;i<n;i++){
            x[i]=r.nextInt(100);
        }
        for(int i=0;i<n-1;i++){
            y[i]=x[i+1];
        }
        for(int i=0;i<n-1;i++){
            z[i+1]=x[i];
        }
        for(int i=0;i<n;i++){
            System.out.print(z[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(y[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }
    }
}