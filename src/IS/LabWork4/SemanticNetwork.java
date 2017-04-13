package IS.LabWork4;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SemanticNetwork {

    private static List<String> facts = new ArrayList<>();
    private static String properties[][];
    private static String recordSplitting[];

    public static void loadFacts() {
        Path file = Paths.get("./src/University/IS/LabWork4/facts.csv");

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            while (scanner.hasNextLine()) {
                facts.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Не найден файл 'facts.csv'. Остановка приложения.");
            System.exit(-1);
        }
    }

    public static void loadProperties() {
        Path file = Paths.get("./src/University/IS/LabWork4/properties.csv");

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            properties = new String[facts.size()][facts.size()];

            while (scanner.hasNextLine()) {
                String split[] = scanner.nextLine().split(";");
                properties[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = split[2];
            }
        } catch (IOException e) {
            System.err.println("Не найден файл 'properties.csv'. Остановка приложения.");
            System.exit(-1);
        }
    }

    public static int subFacts(String claim) {

        recordSplitting = claim.split(" ");

        for(int j = 0; j < facts.size(); j++) {
            if (recordSplitting[0].equals(facts.get(j))) {
                return j;
            }
        }

        System.out.println("Ошибка! Факт не найден.\n");
        System.exit(-1);

        return -1;
    }

    public static int subProperties(String properties[][], int pos) {

        for (int i = pos; i < facts.size(); ++i) {
            for (int j = 0; j < facts.size(); ++j) {
                if (recordSplitting[1].equals(properties[i][j]))  {
                    return j;
                }
            }
        }

        System.out.println("Ошибка! Факт не найден.\n");
        System.exit(-1);

        return -1;
    }

    public static void main(String[] args) {
        loadFacts();
        loadProperties();

        System.out.print("Введите запрос (q - выход): ");
        Scanner in = new Scanner(System.in);
        String claim = in.nextLine().toLowerCase().trim();

        if (claim.equals("q") || claim.equals("Q")) {
            System.exit(-1);
        }

        int factsPos = subFacts(claim);
        int propertiesPos = subProperties(properties, factsPos);
        System.out.println("Результат: " + facts.get(propertiesPos));
    }
}
