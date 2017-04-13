package SSP.LabWork2.variant8.uliana;

public class Task3 {

    public static String swapCase(String str) {
        String temp = "";
        if (str == null) {
            return null;
        } else if (str == "") {
            return "";
        } else {
            char[] chars = str.toCharArray();
            for (char i : chars) {
                if (Character.isLowerCase(i))
                    i = Character.toUpperCase(i);
                else
                    i = Character.toLowerCase(i);
                temp += i;
            }
            return temp;
        }
    }
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Строка: " + str);
        System.out.println("swapCase: " + swapCase(""));

    }
}

