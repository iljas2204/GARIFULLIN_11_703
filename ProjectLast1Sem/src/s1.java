public class s1 {

    public static void main(String[] args) {
        int k = 0;
        int m = 0;
        String Str1 = "aaaaa aasaa aaaaaa";
        for (int i = 1; i < Str1.length(); i++) {
            if (Str1.charAt(i) == 'a') {
                k++;
            } else {
                if (m<k) {
                    m = k;
                }
                k=0;
            }
        }
        if(k>m){
            System.out.println(k);
        }
        else{
            System.out.println(m);
        }
    }
}