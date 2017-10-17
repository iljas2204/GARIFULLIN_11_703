package ClassWork;
import java.util.Scanner;
public class Ex17 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        double sum=0,s,eps=0.0001,t=1;
        int p=-1,k=2;
        double x=scanner.nextDouble();
        while(t>=eps){
            s=t*Math.sin(t*x)*Math.sin(t*x);
            sum+=p*s;
            p=-p;
            t=t*1.0/k;
            k++;
        }
        System.out.println(sum);
    }
}
