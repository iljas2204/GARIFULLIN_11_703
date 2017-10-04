package HomeWork;
public class Ex2 {
    public static void main(String[] args){
        //Задача 5 номер 2 стр21.
        double eps=0.0001,s=0,PI=3.1415926;
        int k=1;
        while (Math.abs(s-PI/4)>eps) {
            if ((k-1)%2==0) s=s+(1.0/(2*k-1));
            else s=s-(1.0/(2*k-1));
            k++;
        }
        System.out.println(s);
        System.out.println(k);
    }
}
