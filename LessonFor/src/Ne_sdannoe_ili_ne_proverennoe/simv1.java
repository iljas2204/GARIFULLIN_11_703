package Ne_sdannoe_ili_ne_proverennoe;

public class simv1 {
    public static void main(String[] args) {
        String string="12032104";
        char max=0;
        for (int i = 0; i <string.length() ; i++) {
            if(string.charAt(i)>max){
                max=string.charAt(i);
            }
        }
        System.out.println(max);
    }
}
