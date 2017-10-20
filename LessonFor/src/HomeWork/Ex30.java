package HomeWork;

import java.util.Scanner;
//Задачи.docx, 14 задача
public class Ex30 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),k=0;
        while(n>0){
            k++;
            n=n/10;
        }
        System.out.println(k);
    }
}
