package HomeWork;

public class Ex3 {
    public static void main(String[] args){
        double x=1,s=0,eps=0.0001,p=-1;
        //задача 6 б стр21.
        int k=1;
        while (Math.abs(x)>eps) {
            s=s+x;
            k=k+2;
            p=-p;
            x=p/(k*k);
        }
        System.out.println(s);
    }
}
