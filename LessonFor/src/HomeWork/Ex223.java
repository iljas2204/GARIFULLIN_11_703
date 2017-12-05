package HomeWork;
//задание 22 , 3
public class Ex223 {
    public static void main(String[] args) {
        int i=0;
        int a []={3,2,2,4,5};
        boolean b=true;
        if((a[0]>a[1])){
            while ((i<a.length-1)&(b)){
                if (a[i]<a[i+1]){
                    b=false;
                }
                i++;
            }
            if(b==false){
                System.out.println("Не упорядочен вообще");
            }
            else{
                System.out.println("Упорядочен по убыванию");
            }
        }
        else{
            while ((i<a.length-1)&(b)){
                if(a[i]>a[i+1]){
                    b=false;
                }
                i++;
            }
            if(b==false){
                System.out.println("Не упорядочен вообще");
            }
            else{
                System.out.println("Упорядочен по возрастанию");
            }

            }
        }
    }
