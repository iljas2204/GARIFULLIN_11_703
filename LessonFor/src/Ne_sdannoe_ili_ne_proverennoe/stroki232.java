package Ne_sdannoe_ili_ne_proverennoe;

public class stroki232 {
    public static void main(String[] args) {
        String number1="hello world";
        String number2="";
        String s;
        boolean f=true;
        for (int i = 0; i <number1.length() ; i++) {
            s= String.valueOf(number1.charAt(i));
            for (int j = 0; j <number2.length()&&f ; j++) {
                if(s.equals(String.valueOf(number2.charAt(j)))){
                    f=false;
                }
            }
            if(f){
                number2+=s;
            }
            f=true;
        }
        System.out.println(number2);
    }
}