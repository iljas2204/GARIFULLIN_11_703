package ClassWork;
import java.util.Scanner;
public class Ex15 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double a0,a,b0,b,eps=0.0001;
        double x=scanner.nextDouble();
        a0=x;
        b0=1-x;
        a=a0 * (1 + (b0 / 2));
        b=b0 * b0 * (3 + b0);
        while (b>eps){
            a0=a;
            b0=b;
            a=a0 * (1 + (b0 / 2));
            b=b0 * b0 * (3 + b0);
        }
        System.out.println(a);
    }
}
