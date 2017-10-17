package HomeWork;
//29б стр 26
public class Ex16 {
    public static void main(String[] args){
        double x0=0,x,eps=0.0001;
        x=Math.cos(x0);
        while (Math.abs(x-x0)>eps){
            x0=x;
            x=Math.cos(x0);
        }
        System.out.println(x);
    }
}
