package HomeWork;//-
import java.util.Scanner;
// 12б, 23 стр
public class Ex10 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double p,s=0,eps=0.0001;
        int n=2,x;
        x=scanner.nextInt();
        p=x;
        while(Math.abs(p)>eps){
            s=s+p;
            p=-p*x*x/(n*(n+1));//неверная формула
            n=n+2;
        }
        System.out.println(s);
    }
}
