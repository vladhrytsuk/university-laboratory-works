package SSP.LabWork3.uliana;

import java.io.*;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String str = "";

        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("-")) {
                String out = in.nextLine();
                str += out;
            }

            if (args[i].equals(">")) {
            	File writeFile = new File(args[i+1]);
                writeFile.createNewFile();
                FileWriter writer = new FileWriter(writeFile); 
                writer.write(str);
                writer.close();
            }

            try (FileReader reader = new FileReader(args[i])) {
                int symbol;
                while ((symbol = reader.read()) != -1) {
                    System.out.print((char) symbol);
                    str += (char) symbol;
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }        
    }
}
