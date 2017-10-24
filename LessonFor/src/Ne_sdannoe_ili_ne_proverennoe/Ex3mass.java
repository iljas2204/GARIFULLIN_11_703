package Ne_sdannoe_ili_ne_proverennoe;
//3 задача классная на массивы
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex3mass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random r=new Random();
        int max=0,maxi=0,p=1,n=scanner.nextInt();
        int [] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(100);
            if(a[i]>max){
                max=a[i];
                maxi=i;
            }
        }
        while(maxi+1<n){
            if(a[maxi+1]!=0){
                p*=a[maxi+1];
            }
            maxi++;
        }
        System.out.println(p);
        System.out.print(Arrays.toString(a));
    }
}
