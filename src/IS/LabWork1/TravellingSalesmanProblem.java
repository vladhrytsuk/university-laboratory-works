package IS.LabWork1;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.String.format;

public class TravellingSalesmanProblem {

    static List<City> listOfCity = new ArrayList<>();
    static Map<String, Double> range = new HashMap<>();
    private static String startingPoint;
    private static String route;
    private static double distance = 0;

    private static final PrintStream stdout = System.out;
    private static final Scanner stdin = new Scanner(System.in);
    private static final int NO_INPUT = -1;


    private static void loadCityTable() {
        Path table = Paths.get("./src/University/IS/LabWork1/City.csv");
        try (Scanner scanner = new Scanner(table, "UTF-8")) {
            City city = new City();
            String currentCity;

            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                String recordSplitting[] = record.split(";");

                currentCity = recordSplitting[0];

                if (!currentCity.equals(city.getName())) {
                    city = new City();
                    range = new HashMap<>();

                    city.setName(recordSplitting[0]);
                    range.put(recordSplitting[1], Double.parseDouble(recordSplitting[2]));
                    city.setRange(range);
                    listOfCity.add(city);
                } else {
                    range.put(recordSplitting[1], Double.parseDouble(recordSplitting[2]));
                    city.setRange(range);
                }
            }
        } catch (IOException e) {
            System.err.println("Не найден файл 'City.csv'. Остановка приложения.");
            System.exit(-1);
        }
    }

    private static int randomCity() {
        Random r = new Random();
        int number = r.nextInt(listOfCity.size());

        route = "";
        distance = 0;

        return number;
    }

    private static int chooseCity() {
        stdout.print(">> ");
        String city = stdin.next();
        int number = -1;

        for (int i = 0; i < listOfCity.size(); i++) {
            if (listOfCity.get(i).getName().equals(city)) {
                number = i;
                break;
            }
        }

        route = "";
        distance = 0;

        return number;
    }

    private static void startingPoint(int number) {
        startingPoint = listOfCity.get(number).getName();
        System.out.println("Starting Point: " + startingPoint);
    }

    private static void nearestNeighborsAlgorithm(int number) {
        startingPoint(number);

        route = listOfCity.get(number).getName();
        String lastPoint;

        Iterator<Map.Entry<String, Double>> iterator = listOfCity.get(number).getRange().entrySet().iterator();

        Map.Entry<String, Double> nextPair = iterator.next();
        Map.Entry<String, Double> prevPair = nextPair;

        while (iterator.hasNext()) {
            nextPair = iterator.next();
            if (prevPair.getValue() > nextPair.getValue()){
                prevPair = nextPair;
            }
        }

        lastPoint = prevPair.getKey();
        route += " -> " + lastPoint;
        distance += prevPair.getValue();

        for (int i = 0; i < listOfCity.size(); i++) {
            if (i != number) {
                iterator = listOfCity.get(i).getRange().entrySet().iterator();
                nextPair = iterator.next();
                prevPair = nextPair;

                while (iterator.hasNext()) {
                    nextPair = iterator.next();

                    if (!route.contains(nextPair.getKey())) {
                        if (prevPair.getValue() > nextPair.getValue()){
                            prevPair = nextPair;
                        } else if (!route.contains(nextPair.getKey()) && route.contains(prevPair.getKey())) {
                            prevPair = nextPair;
                        }
                    } else if (i == listOfCity.size() - 1 && route.contains(prevPair.getKey()) && route.contains(nextPair.getKey())) {
                        if (nextPair.getKey().equals(startingPoint)) {
                            prevPair = nextPair;
                        }
                    }
                }


                if (!route.contains(prevPair.getKey()) || i == listOfCity.size() - 1) {
                    lastPoint = prevPair.getKey();
                    route += " -> " + lastPoint;
                    distance += prevPair.getValue();

                    if (i == listOfCity.size() - 1 && !lastPoint.equals(startingPoint)) {
                        iterator = listOfCity.get(number).getRange().entrySet().iterator();

                        while (iterator.hasNext()) {
                            nextPair = iterator.next();
                            if (nextPair.getKey().equals(lastPoint)) {
                                prevPair = nextPair;
                            }
                        }

                        route += " -> " + startingPoint;
                        distance += prevPair.getValue();
                    }
                }

            } else if (i == number && i == listOfCity.size() - 1) {
                iterator = listOfCity.get(i).getRange().entrySet().iterator();

                while (iterator.hasNext()) {
                    nextPair = iterator.next();
                    if (nextPair.getKey().equals(lastPoint)) {
                        prevPair = nextPair;
                    }
                }

                route += " -> " + startingPoint;
                distance += prevPair.getValue();
            }
        }
    }

    private static void showCityOfTable() {
        for(int i = 0; i < listOfCity.size(); i++) {
            System.out.println("City: " + listOfCity.get(i).getName());
            for(Map.Entry pair: listOfCity.get(i).getRange().entrySet()) {
                System.out.printf("\t\t\t|%-8s|%-6s|%n", pair.getKey(), pair.getValue());
            }
        }
    }

    private static void showResult() {
        if (startingPoint != null) {
            System.out.println("Route: " + route);
            System.out.println("Distance: " + distance);
        } else {
            System.out.println("Please, choose the city!");
        }
    }

    private static void addMenu() {
        System.out.println("1 --- Показать таблицу городов...");
        System.out.println("2 --- Ввести название города...");
        System.out.println("3 --- Выбрать рандомный город...");
        System.out.println("4 --- Показать результат...");
        System.out.println("0 --- Выход\n");
    }

    private static void showMenu() {
        addMenu();
        int number;

        int addOption = userInput(4);
        switch (addOption) {
            case 0:
                return;
            case 1:
                showCityOfTable();
                showMenu();
                break;
            case 2:
                number = chooseCity();
                if(number != -1) {
                    nearestNeighborsAlgorithm(number);
                } else {
                    System.out.println("City not found!");
                }
                showMenu();
                break;
            case 3:
                number = randomCity();
                nearestNeighborsAlgorithm(number);
                showMenu();
                break;
            case 4:
                showResult();
                showMenu();
                break;
        }
    }

    private static int userInput(int maxRange) {
        String userLine = format("@user:(Введите выбор 0..%d)>> ", maxRange);
        int option = NO_INPUT;

        do {
            stdout.print(userLine);
            boolean isNumber = stdin.hasNextInt();
            if (!isNumber) {
                stdin.next();
                stdout.println("Неверная опция: введено не число");
                continue;
            }

            option = stdin.nextInt();

            if (option < 0 || option > maxRange) {
                stdout.println("Неверная опция: " + option);
                option = NO_INPUT;
            }

        } while (option == NO_INPUT);

        return option;
    }

    public static void main(String[] args) {
        loadCityTable();
        showMenu();
    }
}
