package ClassWork;

public class avtomat1 {
    public static void main(String[] args) {
        char array[] = "мэ!".toCharArray();
        int i = 0,state=0;
        boolean isNotfiniteState = true;
        while (isNotfiniteState) {
            switch (state) {
                case 0:
                    if (array[i] != 'м') {
                        isNotfiniteState = false;
                        System.out.println("Не студент");
                    } else {
                        state++;
                        i++;
                        break;
                    }
                case 1:
                    if (array[i] != 'э') {
                        state++;
                        break;
                    } else {
                        i++;
                        break;
                    }
                case 2:
                    if (array[i] != '!') {
                        isNotfiniteState = false;
                        System.out.println("Не студент");
                    } else {
                        System.out.println("Студент");
                        isNotfiniteState=false;
                    }
            }
        }
    }
}
