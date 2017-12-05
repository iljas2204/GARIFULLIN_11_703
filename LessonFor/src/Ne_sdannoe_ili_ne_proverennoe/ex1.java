package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        double x0,x,eps=0.0001;
        Scanner scanner=new Scanner(System.in);
        x0= scanner.nextDouble();
        x=(Math.sin(x0)-x0*x0)/(3-Math.cos(x0));
        for (int i = 0;Math.abs(x-x0)<=eps ; i++) {
            x0=x;
            x=(Math.sin(x0)-x0*x0)/(3-Math.cos(x0));
        }
        System.out.println(x);
    }
}
