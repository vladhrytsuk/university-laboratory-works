package SSP.LabWork3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {

    // ---------- CONST ------------
    private static final int defaultNumberOfBytes = 1000;
    private static final int defaultNumberOfLines = 100;
    private static final String defaultPrefix = "x";
    private static final String pathForSaveFile = "d:\\Network Cloud\\Mail.ru\\Programming Project\\Java - Project\\IDEA\\untitled\\src\\University\\SSP\\LabWork3\\files\\";

    // ---------- COLLECTIONS ------------
    public static ArrayList<String> suffixes = new ArrayList<>();
    public static ArrayList<String> splittingByBytes = new ArrayList<>();
    public static ArrayList<String> splittingByRows = new ArrayList<>();

    // ---------- GLOBAL VARIABLES ------------
    public static int numberOfLines;
    public static int numberOfBytes;
    public static String contentInFile;
    public static String fileName;
    public static String prefix;
    public static String splittingContentsInFile;
    public static int numberSuffix = 0;

    public static void help() {
        System.out.printf("\t\t\t\t\t---------- HELP ----------\n\n");
        System.out.printf("The input format: split [-b | -l] [-d] [input_file [prefix_output_files]]\n\n");
        System.out.printf("|-----------------------------------------------------------------------|\n");
        System.out.printf("|%5s|%-65s|\n", " key ", " description ");
        System.out.printf("|-----------------------------------------------------------------------|\n");
        System.out.printf("|%5s|%-65s|\n", " -b ", " -- bytes=num ");
        System.out.printf("|%5s|%-65s|\n", "    ", " Write into each output file a specified number \"num\" bytes. ");
        System.out.printf("|%5s|%-65s|\n", "    ", " When specifying number of bytes you can use suffixes: ");
        System.out.printf("|%5s|%-65s|\n", "    ", " b means bytes, k - 1kb, m - 1Mb. ");
        System.out.printf("|-----------------------------------------------------------------------|\n");
        System.out.printf("|%5s|%-65s|\n", " -l ", " -- lines=num ");
        System.out.printf("|%5s|%-65s|\n", "    ", " Write into each output file \"num\" lines. ");
        System.out.printf("|-----------------------------------------------------------------------|\n");
        System.out.printf("|%5s|%-65s|\n", " -d ", " -- numeric=suffixes ");
        System.out.printf("|%5s|%-65s|\n", "    ", " Use numeric rather than alphabetic suffixes beginning with 00. ");
        System.out.printf("|%5s|%-65s|\n", "    ", " Suffixes files will be: 00, 01, 02, etc. ");
        System.out.printf("|-----------------------------------------------------------------------|\n");
    }

    public static boolean checkOfFormat(String key) {
        if(key.matches("\\d+")){
            return true;
        } else {
            return false;
        }
    }


    public static void generateSuffixes(String key){
        String suffix;

        if (key.equals("-d")) {
            for(int i = 0; i < 10;i++) {
                for(int j = 0; j < 10; j++) {
                    suffix = "" + i + "" + j + "";
                    suffixes.add(suffix);
                }
            }

            for(int i = 1; i < 10;i++) {
                for(int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        suffix = "" + i + "" + j + "" + k + "";
                        suffixes.add(suffix);
                    }
                }
            }

        } else {
            for(int i = 97; i < 123;i++) {
                for(int j = 97; j < 123; j++) {
                    suffix = "" + (char) i + "" + (char) j + "";
                    suffixes.add(suffix);
                }
            }

            for(int i = 97; i < 123;i++) {
                for(int j = 97; j < 123; j++) {
                    for (int k = 97; k < 123; k++) {
                        suffix = "" + (char) i + "" + (char) j + "" + (char) k + "";
                        suffixes.add(suffix);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        for(int i = 0; i < args.length; i++) {
            if (args[i].contains(".txt")) {
                fileName = args[i];
                try {
                    if (args[i+1].matches("\\w")) {
                        prefix = args[i+1];
                    } else {
                        prefix = " ";
                        break;
                    }
                } catch (Exception ex) {
                    prefix = " ";
                    break;
                }
            }
        }

        for(int i = 0; i < args.length; i++) {

            if (args[i].equals("--help")) {
                help();
                break;
            }

            if (args[2].equals("-d")) {
                generateSuffixes("-d");
            } else {
                generateSuffixes("-s");
            }

            if (args[i].equals("-b") || args[i].equals("-l")) {

                if (args[i].equals("-b")) {
                    if (checkOfFormat(args[i+1])) {
                        numberOfBytes = Integer.parseInt(args[i+1]);
                    } else if (!checkOfFormat(args[i+1])) {
                        numberOfBytes = defaultNumberOfBytes;
                    }

                    Scanner loadFile = new Scanner(new File(fileName));

                    fileName = fileName.substring(0, fileName.length() - 4);

                    while(loadFile.hasNext()) {
                        contentInFile += loadFile.nextLine() + "\r\n";
                    }
                    loadFile.close();

                    splittingContentsInFile = " ";

                    for (int j = 0; j < contentInFile.length(); j++) {

                        if (j % numberOfBytes == 0 && j != 0){
                            splittingByBytes.add(splittingContentsInFile);
                            splittingContentsInFile = " ";
                        }

                        splittingContentsInFile += contentInFile.charAt(j);
                    }

                    splittingByBytes.add(splittingContentsInFile);

                    for (int j = 0; j < splittingByBytes.size(); j++) {
                        File file;

                        if (prefix.equals(" ")) {
                            file = new File(pathForSaveFile + defaultPrefix  + suffixes.get(numberSuffix) + ".txt");
                        } else {
                            file = new File(pathForSaveFile + prefix + fileName + suffixes.get(numberSuffix) + ".txt");
                        }

                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write(splittingByBytes.get(j));
                        writer.close();

                        numberSuffix++;
                    }
                }

                if (args[i].equals("-l")) {
                    if (checkOfFormat(args[i+1])) {
                        numberOfLines = Integer.parseInt(args[i+1]);
                    } else if (!checkOfFormat(args[i+1])) {
                        numberOfLines = defaultNumberOfLines;
                    }

                    Scanner loadFile = new Scanner(new File(fileName));

                    fileName = fileName.substring(0, fileName.length() - 4);

                    while(loadFile.hasNext()) {
                        contentInFile = loadFile.nextLine() + "\r\n";
                        splittingByRows.add(contentInFile);
                    }
                    loadFile.close();

                    splittingContentsInFile = " ";

                    for(int j = 0; j < splittingByRows.size(); j++){
                        if(j % numberOfLines == 0 && j != 0) {
                            File file;

                            if (prefix.equals(" ")) {
                                file = new File(pathForSaveFile + defaultPrefix  + suffixes.get(numberSuffix) + ".txt");
                            } else {
                                file = new File(pathForSaveFile + prefix + fileName + suffixes.get(numberSuffix) + ".txt");
                            }

                            file.getParentFile().mkdirs();
                            file.createNewFile();
                            FileWriter writer = new FileWriter(file);
                            writer.write(splittingContentsInFile);
                            writer.close();

                            numberSuffix++;
                            splittingContentsInFile = " ";
                        }

                        splittingContentsInFile += splittingByRows.get(j);
                    }
                }
            }
        }
    }
}