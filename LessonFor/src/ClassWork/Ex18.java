package ClassWork;
import java.util.Scanner;
public class Ex18 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double b=scanner.nextDouble();
        double a=scanner.nextDouble();
        double x=scanner.nextDouble();
        double v1=a,v2=a,v=v1 + v2,sum=Math.log(a*x)+Math.log(a*x);
        while (v<=b){
            sum+=Math.log(v * x);
            v2=v1;
            v1=v;
            v=v1 + v2;
        }
        System.out.println(sum);
    }
}
