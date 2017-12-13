
public class Vektor2d {
    private double x,y;
    Vektor2d(){
        x = 0;
        y = 0;
    }
    Vektor2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public void setX(double x) { this.x = x; }

    public double getY() { return y; }

    public void setY(double y) { this.y = y; }

    Vektor2d add (Vektor2d vector2D){
        return new Vektor2d(x + vector2D.x, y + vector2D.y);
    }

    public void add2(Vektor2d vector2D){
        x += vector2D.x;
        y += vector2D.y;
    }

    Vektor2d sub (Vektor2d vector2D){
        return new Vektor2d( x - vector2D.x, y - vector2D.y);
    }

    public void sub2(Vektor2d vector2D){
        x -= vector2D.x;
        y -= vector2D.y;
    }

    Vektor2d mult(double a){
        return  new Vektor2d(x*a, y*a);
    }

    public void mult2(double a){
        x *= a;
        y *= a;
    }

    @Override
    public String toString() {
        return ("(" + x + ";" + y + ")");
    }


    public double lenght(){
        return Math.sqrt(x*x + y*y);
    }

    public double scalarProduct( Vektor2d vector2D){
        return (x * vector2D.x + y*vector2D.y);
    }

    public double cos( Vektor2d vector2D){
        return (scalarProduct(vector2D) / (this.lenght() * vector2D.lenght()));
    }

    public boolean eguals (Vektor2d vector2D){
        return ((x == vector2D.x) && (y == vector2D.y) && (this.lenght() == vector2D.lenght()));
    }

}
