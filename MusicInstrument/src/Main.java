public class Main {
    public static void main(String[] args) {
        int n = 3, m = 10;
        Object [][]a=new Object[n][m];
        for (int i = 0; i < n; i++) {
            a[0][i]=new Piano();
            a[1][i]=new Skripka();
            a[2][i]=new Guitar();
        }
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Do u have a guitar?");
        System.out.println("Yes");
        System.out.println(a[2][0]);
    }
}
