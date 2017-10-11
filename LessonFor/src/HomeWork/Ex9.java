package HomeWork;
import java.util.Scanner;
//Задание 12а, стр 23
public class Ex9 {
    public static void main(String[] args){
        double p=1,s=0,eps=0.0001;
        int x,k=1;
        Scanner scanner=new Scanner(System.in);
        x=scanner.nextInt();
        while(p>eps){
            s=s+p;
            p=p*x/k; //исправить
            k++;
        }
        System.out.println(s);
    }
}
