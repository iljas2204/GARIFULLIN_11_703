package HomeWork;
import java.util.Scanner;
// номер 10в , стр 22
public class Ex5 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,x;
        double p=1,s=0;
        n=scanner.nextInt();
        x=scanner.nextInt();
        for (int k=1;k<=n;k++){
            p=p*x*x*(k+k-1)/(k+k);
            s=s+p;
        }
        System.out.println(s);
    }
}
