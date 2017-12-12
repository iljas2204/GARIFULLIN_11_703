package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

public class simv2 {
    public static void main(String[] args) {
        int []a={1,2,143,24,55555};
        int max=0;
        String string=new String();
        for (int i = 0; i <a.length ; i++) {
            string= string.valueOf(a[i]);
            if(max<string.length()){
                max=string.length();
            }
        }
        System.out.println(max);
    }
}
