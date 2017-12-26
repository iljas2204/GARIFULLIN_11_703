package Ne_sdannoe_ili_ne_proverennoe;

import java.util.Scanner;

public class stroki300 {
    public static void main(String[] args) {
        boolean f1=false,f2=false,f3=false;
        Scanner scanner=new Scanner(System.in);
        String password=scanner.nextLine();

        for (int i = 0; i <password.length() ; i++) {
            if(password.charAt(i)>47&&password.charAt(i)<58&&!f1){
                f1=true;
            }
            if(password.charAt(i)>64&&password.charAt(i)<91&&!f2){
                f2=true;
            }
            if(password.charAt(i)>96&&password.charAt(i)<123&&!f3){
                f3=true;
            }
        }
        if(f1&&f2&&f3&&password.length()>7){
            System.out.println("Криптостойкий пароль");
        }
        else {
            System.out.println("Не криптостойкий");
        }
    }
}
