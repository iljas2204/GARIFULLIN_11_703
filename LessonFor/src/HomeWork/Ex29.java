package HomeWork;

import java.util.Scanner;
//Задачи.docx, 13 задача
public class Ex29 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),s=0,p=1;
        while (n>0){
            s+=p*(n%10);
            n=n/10;
            p=-p;
        }
        System.out.println(s);
    }
}
