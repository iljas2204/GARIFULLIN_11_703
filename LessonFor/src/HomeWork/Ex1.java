package HomeWork;
import java.util.Scanner;
//Номер 10, упражнение 1
public class Ex1 {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n,x;
        double s=0;
        long z=1;
        n=scanner.nextInt();
        x=scanner.nextInt();
        for (int k=0;k<=n;k++) {
            z =z*k;             //быстро наступит переполнение
            if (z==0) z=1;     //todo объяснить
            if (k % 2 == 1) {
                s = s - (Math.pow(x, 2 * k + 1) / ((2 * k + 1) * z));   //плохо считаем степень
            } else s = s + (Math.pow(x, 2 * k + 1) / ((2 * k + 1) * z));//плохо считаем степень
        }
        System.out.println(s);
    }
}
