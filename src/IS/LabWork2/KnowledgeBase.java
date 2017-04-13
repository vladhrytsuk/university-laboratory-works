package IS.LabWork2;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KnowledgeBase {

    public static void main(String[] args) {
        Path file = Paths.get("./src/University/IS/LabWork2/condition.csv");
        Map<String, String> conditions = new HashMap<>();

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                String recordSplitting[] = record.split("\"");

                conditions.put(recordSplitting[1], recordSplitting[3]);

            }
        } catch (IOException e) {
            System.err.println("Не найден файл 'condition.csv'. Остановка приложения.");
            System.exit(-1);
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Введите условие: ");
        String condition = in.next();

        for(Map.Entry pair: conditions.entrySet()) {
            if (pair.getKey().toString().contains(condition)) {
                System.out.println(pair.getKey() + " - " + pair.getValue());
            }
        }

        in.close();
    }
}
