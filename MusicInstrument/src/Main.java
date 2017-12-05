public class Main {
    public static void main(String[] args) {
        int n = 3, m = 10;
        Object [][]a=new Object[n][m];
        for (int i = 0; i < n; i++) {
            a[0][i]=new Piano();
            a[2][i]=new Guitar();
            a[1][i]=new Skripka();
        }
        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Do u have a skripka?");
        System.out.println("Yes");
        System.out.println(a[1][0]);
    }
}
