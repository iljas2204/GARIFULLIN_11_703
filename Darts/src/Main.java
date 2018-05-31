import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("numbers.txt"));
        Circle circles[] = new Circle[scanner.nextInt()];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(scanner.nextInt(), scanner.nextInt());
        }

        int n = scanner.nextInt(), x = 0, z;
        boolean f;
        for (int i = 0; i < n; i++) {
            z = 0;
            f = true;
            Shoot shoot = new Shoot(scanner.nextInt(), scanner.nextInt());
            while (z < circles.length && f)
                if (circles[z].getRadius() - shoot.calcRadius() >= 0) { //radius circle[0]< radius circle[1]<..etc
                    x += circles[z].getScore();
                    f = false;
                } else {
                    z++;
                }
        }
        System.out.println(x);
    }
}
