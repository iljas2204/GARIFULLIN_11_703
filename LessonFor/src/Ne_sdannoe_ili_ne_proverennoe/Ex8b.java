package Ne_sdannoe_ili_ne_proverennoe;//-

public class Ex8b {
    public static void main(String[] args) {
        int [] s={1,4,2,3,9};
        int [] t1={1};
        int z=0;
        int [] t2={1,4,2};
        int [] b1=new int[s.length];
        int [] b2=new int[s.length];
        l:
        for(int i=0;i<t2.length;i++){
            for (int x=0;x<t1.length;x++){
                if(t2[i]==t1[x]){
                    z++;
                    break l;
                }
            }
        }
        if(z==t1.length){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}   //какое-то странное решение. А где характеристические векторы?
