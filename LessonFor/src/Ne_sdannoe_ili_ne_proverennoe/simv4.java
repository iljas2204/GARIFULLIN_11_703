package Ne_sdannoe_ili_ne_proverennoe;

public class simv4 {
    public static void main(String[] args) {
        String string1="sss";
        String string2="ss";
        boolean f=true;
        if(string2.length()>string1.length()){
        for (int i = 0; i < string2.length(); i++) {
            if (string1.charAt(i) != string1.charAt(i)) {
                f = false;
            }
        }
        }
        else {
            for (int i = 0; i < string1.length(); i++) {  
                if (string1.charAt(i) != string2.charAt(i)) {
                    f = false;
                }
            }
        }
        System.out.println(f);
    }
}
