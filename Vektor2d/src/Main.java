public class Main {
    public static void main(String[] args) {
        Vektor2d vector2D = new Vektor2d(5, 8);
        Vektor2d vector2D1 = new Vektor2d(9, 10);
        System.out.println(vector2D);
        vector2D.sub2(vector2D1);
        System.out.println(vector2D);
    }
}
