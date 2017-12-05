package HomeWork;
//2 классная задача по массивам
import java.util.Random;
import java.util.Scanner;

public class Ex2mass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random r=new Random();
        int n=scanner.nextInt();
        int [] a=new int[n];
        int p=0,maxi=0,mini=0,max=0,min=100;
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(100);
            if (a[i]>max){
                max=a[i];
                maxi=i;
            }
            if (a[i]<min){
                min=a[i];
                mini=i;
            }
        }
        if (mini>maxi){
            while(maxi+1<mini){
                p+=a[maxi+1];
                maxi++;
            }
        }
        if (maxi > mini) {
            while (mini+1<maxi){
                p+=a[mini+1];
                mini++;
            }
        }
        if (maxi==mini){
            p=a[maxi];
        }
        System.out.println(p);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
