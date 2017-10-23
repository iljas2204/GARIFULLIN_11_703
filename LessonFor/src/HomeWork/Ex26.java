package HomeWork;//+

import java.util.Scanner;
//14б
public class Ex26 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double a=scanner.nextDouble(),t=1/a;
        double x=scanner.nextDouble(),eps=0.0001,s=0;
        while(t>=eps){
            s+=t*Math.log(t*x);
            t*=1/a;
        }
        System.out.print(s);
    }
}
