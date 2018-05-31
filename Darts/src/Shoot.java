public class Shoot {
    private int x;
    private int y;

    public Shoot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double calcRadius() {
        return Math.sqrt(x * x + y * y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
