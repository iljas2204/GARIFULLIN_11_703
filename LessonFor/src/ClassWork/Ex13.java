package ClassWork;
import java.util.Scanner;
//задание 26, стр 25
public class Ex13 {
    public static void main(String[] args){
        double y0,y,eps=0.0001;
        Scanner scanner=new Scanner(System.in);
        double x=scanner.nextDouble();
        if (x>=1) y0=x/3;
        else y0=x;
        y=y0 - 1.0 / 3 * (y0 - x / (y0*y0));
        while (Math.abs(y - y0)>eps){
            y0 = y;
            y=y0 - 1.0 / 3 * (y0 - x / (y0 * y0));
        }
        System.out.println(y);
    }
}
