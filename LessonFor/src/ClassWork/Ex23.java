package ClassWork;

import java.util.Random;
import java.util.Scanner;

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
        
    }
}
