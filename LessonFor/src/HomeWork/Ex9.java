package HomeWork;
import java.util.Scanner;
//Задание 12а, стр 23
public class Ex9 {
    public static void main(String[] args){
        double p=1,s=1,eps=0.0001;
        int x,k=1;
        Scanner scanner=new Scanner(System.in);
        x=scanner.nextInt();
        while(p>eps){
            p=p*x/k;// Логика нарушена
            k++;
            s=s+p;
        }
        System.out.println(s);
    }
}
