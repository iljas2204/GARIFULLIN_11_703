package HomeWork;
import java.util.Scanner;
// 12б, 23 стр
public class Ex10 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double p,s,eps=0.0001;
        int n=2,x;
        x=scanner.nextInt();
        p=x;
        s=x;
        while(Math.abs(p)>eps){
            p=-p*x*x/(n*(n+1));  //Логика нарушена. 
            s=s+p;
            n=n+2;
        }
        System.out.println(s);
    }
}
