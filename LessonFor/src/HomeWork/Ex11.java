package HomeWork;
import java.util.Scanner;
//задача 12в, стр 23
public class Ex11 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double x,p,eps=0.0001,s;
        int n=2;
        x=scanner.nextDouble();
        p=x;
        s=x;
        while(Math.abs(p)>eps){
            p=-p*x*(n-1)/n;
            s=s+p;
            n++;
        }
        System.out.println(s);
    }
}
