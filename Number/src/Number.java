import java.io.Serializable;

public class Number implements Serializable {
    String firstNumber;
    String secondNumber;

    public Number(String firstNumber, String secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public static String summ(String firstNumber, String secondNumber) {
        String add = new String();
        String maxstr, minstr;
        int unitInMind = 0, sum;
        if (firstNumber.length() > secondNumber.length()) {
            maxstr = firstNumber;
            minstr = secondNumber;
        } else {
            maxstr = secondNumber;
            minstr = firstNumber;
        }
        if (minstr.equals("")) return maxstr;
        for (int i = 0; i < maxstr.length(); i++) {
            if (minstr.length() - i > 0) {
                sum = Character.getNumericValue(maxstr.charAt(maxstr.length() - 1 - i)) +
                        Character.getNumericValue(minstr.charAt(minstr.length() - 1 - i)) + unitInMind;
            } else {
                sum = Character.getNumericValue(maxstr.charAt(maxstr.length() - 1 - i)) + unitInMind;
            }
            if (sum > 9) {
                unitInMind = sum / 10;
                sum %= 10;
            } else unitInMind = 0;

            add = sum + add;
        }

        if (unitInMind > 0) add = unitInMind + add;
        return add;
    }

    public static String multiplication(String number1, String number2) {
        String plus1 = "";
        String plus2 = "";
        int mod;
        String mult = new String();
        String numberF = new String();
        String numberT = new String();

        for (int i = 0; i < number1.length(); i++) {
            for (int j = number2.length() - 1; j >= 0; j--) {
                for (int l = number1.length() - 1; l >= 0; l--) {
                    mod = (number1.charAt(l) - (int) '0') * (number2.charAt(j) - (int) '0');
                    numberF = summ(numberF, String.valueOf(mod) + plus1);
                    plus1 += "0";
                }
                numberT = summ(numberT, numberF);
                numberF = "";
                plus1 = "";
            }
            mult = summ(mult, numberT + plus2);
            numberT = "";
            plus2 += "0";
        }
        return mult;
    }

    public static void main(String[] args) {
        Number number = new Number("23", "21");
        System.out.println(summ(number.firstNumber, number.secondNumber));
    }
}
