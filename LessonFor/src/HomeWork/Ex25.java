package HomeWork;//+

import java.util.Scanner;
//32б
public class Ex25 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double x,eps=0.0001;
        double x0=scanner.nextDouble();
        x=1+9*Math.sin(x0)/2;
        while (Math.abs(x-x0)>eps){
            x0=x;
            x=1+9*Math.sin(x0)/2;
        }
        System.out.print(x);
    }
}
