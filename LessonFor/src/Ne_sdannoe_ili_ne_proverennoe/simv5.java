package Ne_sdannoe_ili_ne_proverennoe;

public class simv5 {
    public static void main(String[] args) {
        String string1="blackblackcat";
        String string2="cat";
        int n=0;
        boolean f=false;
        for (int i = 0; i <string1.length()&&!f ; i++) {
            if(string1.charAt(i)==string2.charAt(n)){
                n++;
                if(n==string2.length()){
                    f=true;
                }
            }
            else {
                n=0;
            }
        }
        System.out.println(f);
    }
}
