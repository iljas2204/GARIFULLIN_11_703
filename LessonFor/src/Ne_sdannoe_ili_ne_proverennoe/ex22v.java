package Ne_sdannoe_ili_ne_proverennoe;

public class ex22v {
    public static void main(String[] args) {
        boolean f=true;
        int []a={1,2,3,4,1,2};
        for (int i = 0; i <a.length-1&&f ; i++) {
            if (a[i]>a[i+1]){
                f=false;
            }
        }
        if(f){
            System.out.println("Массив упорядочен по возрастанию");
        }
        else{
            f=true;
            for (int i = 0; i <a.length-1 ; i++) {
                if (a[i]<a[i+1]) {
                    f=false;
                }
            }
            if(f){
                System.out.println("Массив упорядочен по убыванию");
            }
            else {
                System.out.println("Массив не упорядочен");
            }
        }

    }
}
