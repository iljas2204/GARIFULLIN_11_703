package ClassWork;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt(),sum=0;
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=(int) Math.round(Math.random() * 100)-30;
            if (a[i]>0){
                sum+=a[i];
            }
        }
        System.out.println(sum);
    }
}
