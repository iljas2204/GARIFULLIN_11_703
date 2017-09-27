package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int i=a;
        while (i <= b) {
            System.out.print(i + " "); // неверно
            i++;
        }
    }
}
