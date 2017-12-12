package Ne_sdannoe_ili_ne_proverennoe;

public class simv3 {
    public static void main(String[] args) {
        String string="1571117";
        int x;
        boolean f=false;
        for (int i = 0; i <string.length()&&!f ; i++) {
            x=string.charAt(i);
            if(x%2==0||x%3==0){
                f=true;
            }
        }
        System.out.println(f);
    }
}
