package ClassWork;
import java.util.Scanner;
public class Ex14 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double eps=0.0001,a0,b0,a,b,x=scanner.nextDouble();
        a0=1;
        b0=1-x;
        a=a0 * (1 + b0);
        b=b0 * b0;
        while (b>eps) {
            a0=a;
            b0=b;
            a=a0 * (1 + b0);
            b=b0 * b0;
        }
        System.out.println(a);
    }
}
