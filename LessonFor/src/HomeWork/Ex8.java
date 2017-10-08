package HomeWork;
//задание 7 стр 22
public class Ex8 {
    public static void main(String[] args){
        double s=1,PI=3.1415926,eps=0.0001;
        int k=1;
        while (Math.abs(s-PI/2)>eps){
            s=s*4*k*k/(4*k*k-1);
            k++;
        }
        System.out.println(s);
    }
}
