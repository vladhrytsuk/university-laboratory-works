package SSP.LabWork1;

import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String buf = "";

        while ( in.hasNextInt() ) {
            buf += Integer.toString(in.nextInt());
        }

        System.out.println(buf);
    }

}
