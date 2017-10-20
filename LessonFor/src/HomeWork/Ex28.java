package HomeWork;

import java.util.Scanner;
//24a
public class Ex28 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double eps=0.0001,m=scanner.nextDouble(),x=scanner.nextDouble();
        double sin=Math.sin(x),s=0,cos=Math.cos(x),b1=cos,c1=sin,t=sin,c,b;
        int n=1;
        while ((n<=m)|(Math.abs(t)>=eps)){
            s+=t;
            c=c1*cos+sin*b1;
            b=b1*cos-c1*sin;
            n++;
            t*=c/(n*c1);
            b1=b;
            c1=c;
        }
        System.out.println(s+" "+t+" "+n);
        System.out.println(sin);

    }
}
