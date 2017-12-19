package Ne_sdannoe_ili_ne_proverennoe;//-

public class simv4 {
    public static void main(String[] args) {
        String string1="sss";
        String string2="ss";
        boolean f=true;
        for (int i = 0; i <string1.length() ; i++) {  //not taken into account the length
         if(string1.charAt(i)!=string2.charAt(i)){
             f=false;
         }
        }
        System.out.println(f);
    }
}
