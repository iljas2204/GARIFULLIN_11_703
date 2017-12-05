package HomeWork;//-//+
import java.util.Scanner;
//задача 12г, стр 23
public class Ex12g {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double p=1,s=0,eps=0.0001;
        int x,n=1;
        x=scanner.nextInt();
        while(Math.abs(p)>eps){
            s+=p;
            p=-p*x*x/(2*n*(2*n-1));//исправлено
            n+=2;
        }
        System.out.println(s);
        System.out.println(p);
    }
}

