package HomeWork;
import java.util.Scanner;
//10b , страница 22
public class Ex4 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,x;
        double p,s=0;
        n=scanner.nextInt();
        x=scanner.nextInt();
        p=x;
        for (int k=1;k<=n;k++) {
            s+= p;
            p=-p*x*x*x*x*(4*k-3)/((2*k-1)*2*k*(4*k+1));
        }
        System.out.println(s);
    }
}
