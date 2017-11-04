package Semestrovka;

public class Semestr2 {
    public static void main(String[] args) {
        double y, u0 = 1.0, u = 0.0;
        double[] x = {-0.8, 1.2, 3.2};
        int n = 27;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < 0) {
                y = Math.log(x[i] * x[i] + 2.7);
                for (int z = 0; z < n; z++) {
                    u = (2.0 / 3) * u0 + (y) / (3 * u0 * u0);
                    u0 = u;
                }
            } else {
                y = Math.log(x[i] + 2.7);
                for (int z = 0; z < n; z++) {
                    u = (2.0 / 3) * u0 + (y) / (3 * u0 * u0);
                    u0 = u;
                }
            }
            System.out.println("y" + (i + 1) + "=" + u);
        }
    }
}
