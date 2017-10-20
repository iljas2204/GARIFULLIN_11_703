package HomeWork;

import java.util.Scanner;
//Задачи.docx, 15 задача
public class Ex31 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int s=0,p,n=scanner.nextInt();
        while (n>0){
            p=n%10;
            if (p%2==1){
                s=s*10+p;
                n=n/10;
            }
            else {
                n=n/10;
            }
        }
        while (s>0){
            p=s%10;
            n=n*10+p;
            s=s/10;
        }
        System.out.println(n);
    }
}
