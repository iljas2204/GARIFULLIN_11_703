package HomeWork;

import java.util.Scanner;
//30а
public class Ex24 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double x,x0,eps=0.0001;
            if ((1.1*1.1*1.1*1.1*1.1-1.1-0.002)*(20*1.1*1.1*1.1)>0){
                x0=1.1;
            }
            else{
                x0=1.0;
            }
            x=x0-(x0*x0*x0*x0*x0-x0-0.002)/(5*x0*x0*x0*x0-1);
            while(Math.abs(x-x0)>eps){
                x0=x;
                x=x0-(x0*x0*x0*x0*x0-x0-0.002)/(5*x0*x0*x0*x0-1);
            }
            System.out.print(x);
    }
}
