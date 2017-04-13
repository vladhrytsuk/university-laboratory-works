package IS.LabWork1.uliana;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravellingSalesmanProblem {

    private static int distance;
    private static int oldMin;
    private static List<Integer> columns;
    private static City city;

    public static void restart() {
        oldMin = 100;
        columns = new ArrayList<>();
        distance = 0;
    }

    public static int getMinCollumnByIndexWithIgnoreColumns(int i) {
        if (i < city.getCountOfCity()) {
            int min = 100;
            int indexMin = 100;

            for (int j = 1; j < city.getCountOfCity(); j++) {
                if (city.getTableOfCity()[i][j] < min && city.getTableOfCity()[i][j] != 0 && !columns.contains(j) && city.getTableOfCity()[i][j] != oldMin) {
                    min = city.getTableOfCity()[i][j];
                    indexMin = j;
                }
            }

            System.out.println(". From city " + (i + 1) + " to city " + (indexMin + 1) + ", distance: " + min);

            columns.add(indexMin);
            oldMin = min;

            return min;
        } else {
            return -1;
        }
    }

    public static int calculateDistance() {
        int j = 0;

        for (int i = 0; i < city.getCountOfCity() - 1; i++) {
            System.out.print("Step №" + (i + 1));
            distance += getMinCollumnByIndexWithIgnoreColumns(j);
            j = columns.get(i);
        }

        distance += city.getTableOfCity()[j][0];

        System.out.println("Step №" + city.getCountOfCity() + ". From city " + (j + 1) + " to city 1, distance: " + city.getTableOfCity()[j][0]);

        return distance;
    }

    public static void showDistance() {
        System.out.println("\nDistance: " + calculateDistance());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter count of city: ");
        int countOfCity = in.nextInt();

        city = new City(countOfCity);
        city.initializationTableOfCities();
        city.showTableOfCity();
        restart();
        showDistance();
    }
}
