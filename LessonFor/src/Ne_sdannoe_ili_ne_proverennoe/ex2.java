package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt(),p=-1;
        double eps=0.00001,sum=0,z=1;
        for (int k = 0; z>eps ; k++) {
            z=p/(x*(2*k+1));
            sum+=z;
            p=-p;
            x*=x*x;
        }
        sum=(3.14*Math.sqrt(x*x))/(2*x)-sum;
        System.out.println(sum);
    }
}
