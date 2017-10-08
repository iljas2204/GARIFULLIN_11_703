package HomeWork;
import java.util.Scanner;
//задание 11а, стр23
public class Ex7 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double p,s=0;
        int n;
        n=scanner.nextInt();
        for(int m=1;m<=n;m++){
            for(int k=1;k<=m;k++){
                p=n+(k/n);
                s=s+Math.sin(p);
            }
        }
        System.out.println(s);
    }
}
