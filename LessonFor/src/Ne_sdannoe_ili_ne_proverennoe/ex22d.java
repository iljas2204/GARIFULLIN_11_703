package Ne_sdannoe_ili_ne_proverennoe;

public class ex22d {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 2};
        int z = 0;
        boolean f;
        for (int i = 0; i < a.length; i++) {
            f = true;
            for (int j = 0; j < a.length && f; j++) {
                if (a[i] == a[j] && i != j) {
                    f = false;
                }
            }
            if (f) {
                z++;
            }
        }
        System.out.println(z);
    }
}
