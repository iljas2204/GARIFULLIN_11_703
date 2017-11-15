package Ne_sdannoe_ili_ne_proverennoe;//-

public class Ex8b {
    public static void main(String[] args) {
        int [] t1={1,0,1,0,1};
        int z=0;
        int [] t2={1,1,1,0,0};
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
            System.out.println("Множество включается");
        }
        else{
            System.out.println("Множество не включается");
        }
    }
}
