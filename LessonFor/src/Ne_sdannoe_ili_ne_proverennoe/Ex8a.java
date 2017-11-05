package Ne_sdannoe_ili_ne_proverennoe;

public class Ex8a {
    public static void main(String[] args) {
        int [] s={1,4,2,3,9};
        int [] t1={1,9};
        int [] t2={1,4,2};
        int [] b1=new int[s.length];
        int [] b2=new int[s.length];
        int k=0;
        for (int i=0;i<t1.length;i++){
            for (int x=0;x<s.length;x++){
                if(t1[i]==s[x]){
                    b1[x]=1;
                    k++;
                }
            }
        }
        System.out.println(k);
    }
}
