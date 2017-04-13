package IS.LabWork1.uliana;

public class City {

    private int countOfCity;
    private int[][] tableOfCity;

    public City(int countOfCity) {
        this.countOfCity = countOfCity;
        this.tableOfCity = new int[this.countOfCity][this.countOfCity];
    }

    public int getCountOfCity() {
        return countOfCity;
    }

    public int[][] getTableOfCity() {
        return tableOfCity;
    }

    public void initializationTableOfCities() {
        for (int i = 0; i < countOfCity; i++) {
            for (int j = i; j < countOfCity; j++) {
                if (i == j) {
                    tableOfCity[i][j] = 0;
                } else {
                    tableOfCity[i][j] = tableOfCity[j][i] = (int) (Math.random() * 100);
                }
            }
        }
    }

    public void showTableOfCity() {
        System.out.println("Show table of city:");

        for (int i = 0; i < countOfCity; i++) {
            System.out.println("----------------------------------------------------");
            System.out.print("||");
            for (int j = 0; j < countOfCity; j++) {
                System.out.printf("%4d|", this.tableOfCity[i][j]);
            }
            System.out.println();
        }

        System.out.println("----------------------------------------------------\n");
    }




}
