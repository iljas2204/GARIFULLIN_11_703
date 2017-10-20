package HomeWork;

import java.util.Scanner;
//23б
public class Ex27 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
        double x=scanner.nextDouble();
        double v,v0=a,v1=a,s=0,p=-1;
        v=v0+v1;
        while(v<=b){
            s+=(p*v/2)*Math.cos(v*x)*Math.cos(v*x);
            v0=v1;
            p=-p;
            v1=v;
            v=v0+v1;
        }
        System.out.print(s);
    }
}
