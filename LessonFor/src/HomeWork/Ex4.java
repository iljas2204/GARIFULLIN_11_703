package HomeWork;
import java.util.Scanner;
//10b , страница 22
public class Ex4 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,x;
        double p,s;
        n=scanner.nextInt();
        x=scanner.nextInt();
        p=x;
        s=x;
        for (int k=1;k<=n;k++) {
            p=p*x*x*x*x*(4*k-3)/((2*k-1)*2*k*(4*k+1));
            if (k % 2 == 1) {
                s = s - p;
            } else s = s + p;
        }
        System.out.println(s);
    }
}
