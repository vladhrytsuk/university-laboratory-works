package SSP.LabWork2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static boolean pangramEng(String str) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public static void main(String[] args) {
        String str = "asidhiaghiuhsiuvchasiuhfuiahuishuaiseusie";
        System.out.println("Строка: " + str);
        System.out.println(pangramEng(str));
    }
}
