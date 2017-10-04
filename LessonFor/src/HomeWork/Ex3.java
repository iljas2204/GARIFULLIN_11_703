package HomeWork;

public class Ex3 {
    public static void main(String[] args){
        double x=1,s=1,eps=0.0001,p=-1;
        //задача 6 б стр21.
        int k=3;
        while (Math.abs(x)>eps) {
            x=p/(k*k);
            s=s+x;
            k=k+2;
            p=-p;
        }
        System.out.println(s);
    }
}
