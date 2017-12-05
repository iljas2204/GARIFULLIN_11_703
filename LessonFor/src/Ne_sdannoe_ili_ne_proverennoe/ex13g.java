package Ne_sdannoe_ili_ne_proverennoe;

public class ex13g {
    public static void main(String[] args) {
        int []a={0,0,1,2,3,4,4,4,4,7,5};
        int []b=new int[a.length];
        int j=0;
        for (int i = 0; i <a.length-1 ; i++) {
            if (a[i]==a[i+1]){
                b[j]++;
            }
            else {
                b[j]++;
                j++;

            }
        }
        b[j]++;
        for (int i=0;i<a.length;i++) {
            System.out.print(b[i]);
        }
    }
}
