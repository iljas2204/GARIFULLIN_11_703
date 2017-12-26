package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

public class stroki234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        int n = 0,s;
        while (f){
            n=scanner.nextInt();
            s=n;
            while(n>0) {
                if(n%10==1||n%10==0){
                    n=n/10;
                }
                else{
                    s=-1;
                    break;
                }
            }
            if(s!=-1){
                int k=1;
                while(s>0) {
                    n=n+s%10*k;
                    k*=2;
                    s=s/10;
                }
                f=false;
            }
        }
        System.out.println(n);
    }
}
