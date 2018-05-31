package ru.itis;

import java.io.*;

public class PackageName {
    File file;
    public String packageName(String url, String className) throws IOException {
        this.file = new File(url);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file + "\\" + className ));
        className = className.replaceAll(".class", "");

        String equalsName = "";
        int i;
        int remember;
        boolean flag = false;
        boolean flag2 = false;
        while (!flag || !flag2) {
            i = 0;
            remember = i;
            String string = bufferedReader.readLine();
            if(string == null){
                return "";
            }
            while (!equalsName.equals("SourceFile") && string.length() > i && !flag) {
                equalsName += string.charAt(i);
                if (equalsName.length() > "SourceFile".length()) {
                    equalsName = equalsName.substring(1);
                }
                i++;
                if (equalsName.equals("SourceFile")) {
                    flag = true;
                }
            }
            equalsName = "";
            while (!equalsName.equals("/" + className) && string.length() > i && flag && !flag2) {
                equalsName += string.charAt(i);
                if (string.charAt(i) == "/".charAt(0)) {
                    remember = i;
                }
                if (equalsName.length() > ("/" + className).length()) {
                    equalsName = equalsName.substring(1);
                }
                if (equalsName.equals("/" + className)){
                    flag2 = true;
                }
                i++;
            }
            equalsName = "";
            i = remember;
            while (i > 0 && ((string.charAt(i) > "a".charAt(0) && string.charAt(i) < "z".charAt(0)) || string.charAt(i) == "/".charAt(0)) && flag) {
                equalsName += string.charAt(i);
                i--;
            }
            if(flag && flag2 ) {
                equalsName = new StringBuilder(equalsName).reverse().toString();
                equalsName = equalsName.replaceAll("/", ".");
                return equalsName;
            }
        }
        return "";
    }
}
