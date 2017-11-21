package Ne_sdannoe_ili_ne_proverennoe;//+- //+
import java.util.Scanner;
//Номер 10а
public class ex10a {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n,x;
        double p,s;
        n=scanner.nextInt();
        x=scanner.nextInt();
        p=x;
        s=x;
        for (int k=1;k<=n;k++) {
            p=p*x*x*(2*k-1)/(k*(2*k+1));
            if (k % 2 == 1) {  //это не очень хорошая идея... Почему?  most likely I'm not right
                s = s - p;   
            } else s = s + p;
        }
        System.out.println(s);
    }
}
