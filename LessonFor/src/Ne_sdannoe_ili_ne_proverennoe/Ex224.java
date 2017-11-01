package Ne_sdannoe_ili_ne_proverennoe;
// задание 22, 4
public class Ex224 {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6,7};
        int i=0;
        boolean b=false;
        while(i< a.length-1&b==false){
            for(int z=i+1;z<a.length;z++){
                if(a[i]==a[z]){
                    b=true;
                }
            }
            i++;
        }
        System.out.print(b);
    }
}
