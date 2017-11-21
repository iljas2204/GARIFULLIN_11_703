package Ne_sdannoe_ili_ne_proverennoe;//- //+
import java.util.Scanner;
// 12б, 23 стр
public class Ex12b {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double p,s=0,eps=0.0001;
        int n=2,x;
        x=scanner.nextInt();
        p=x;
        while(Math.abs(p)>eps){
            s=s+p;
            p=-p*x*x/((2*n)*(2*n+1));//исправлено
            n=n+2;
        }
        System.out.println(s);
    }
}
