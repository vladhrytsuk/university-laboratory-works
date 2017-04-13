package SSP.LabWork3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    // ---------- CONST ------------
    private static final int numberOfLines = 58;
    private static final String pathForSaveFile = "d:\\Network Cloud\\Mail.ru\\Programming Project\\Java - Project\\IDEA\\untitled\\src\\University\\SSP\\LabWork3\\files\\";

    // ---------- COLLECTIONS ------------
    public static ArrayList<String> rowsOfFile = new ArrayList<>();
    public static ArrayList<String> filesName = new ArrayList<>();

    // ---------- GLOBAL VARIABLES ------------
    public static String contentInFile;
    public static String splittingContentsInFile = "";
    public static int numberOfPages = 0;

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains(".txt")) {
                filesName.add(args[i]);
            }
        }

        for (int i = 0; i < filesName.size(); i++) {
            Scanner loadFile = new Scanner(new File(filesName.get(i)));

            while(loadFile.hasNext()) {
                contentInFile = loadFile.nextLine() + "\r\n";
                rowsOfFile.add(contentInFile);
            }

            loadFile.close();

            numberOfPages++;
            splittingContentsInFile += "\n\n\t\t\t\t\tFile: " + filesName.get(i) + ", " + numberOfPages + " - page.\n\n";

            for(int j = 0; j < rowsOfFile.size(); j++) {
                if(j % numberOfLines == 0 && j != 0) {
                    numberOfPages++;
                    splittingContentsInFile += "\n\n\t\t\t\t\tFile: " + filesName.get(i) + ", " + numberOfPages + " - page.\n\n";
                }
                splittingContentsInFile += rowsOfFile.get(j);
            }
        }

        System.out.println(splittingContentsInFile);

        File file = new File(pathForSaveFile + "result.txt");

        file.getParentFile().mkdirs();
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(splittingContentsInFile);
        writer.close();
    }
}
