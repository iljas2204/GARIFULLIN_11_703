import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Scanner {
    FileInputStream fileInputStream;

    {
        try {
            fileInputStream = new FileInputStream("input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int nextInt() throws IOException {
        int integer = 0;
        int scan = fileInputStream.read();
        if(scan != 45 && (scan < 48 || scan > 59)){
            System.out.print("Не число : ");
        }
        if(scan != 45) {
            while (scan != -1 && scan != 32) {
                integer = integer * 10 + ((char) scan - 48);
                scan = fileInputStream.read();
            }
        }
        else  {
            while (scan != -1 && scan != 32) {
                if(scan != 45) {
                    integer = integer * 10 + ((char) scan - 48);
                }
                    scan = fileInputStream.read();
            }
            integer = - integer;
        }
        return integer;
    }
}
