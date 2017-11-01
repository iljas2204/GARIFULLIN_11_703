package Semestrovka;

public class Semestr1 {
    public static void main(String[] args) {
        int n=38,m=7;
        double h=1.3;
        double []z=new double[n];
        int [] f=new int[m];
        z[0]=-0.85;
        z[1]=14.02;
        for(int i=2;i<n;i++){
            z[i]=(Math.log(1+(z[i-2]*z[i-2]))/Math.log(1+(z[i-1]*z[i-1])));
        }
        for(int j=1;j<=m;j++){
            for (int i=0;i<n;i++) {
                if (((j - 1) * h <= Math.abs(z[i]))&((j*h>Math.abs(z[i])))){
                    f[j-1]++;
                }
            }
        }
        for (int i = 0; i <m ; i++) {
            System.out.print(f[i]+" ");
        }
    }
}
