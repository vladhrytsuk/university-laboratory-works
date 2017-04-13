package SSP.LabWork2;

public class Task4 {
    public static void main(String[] args) {
        double z = 3.5, h = 0.1, min = 0, max = 0;
        double fun[] = new double[20];
        int i = 0;

        for (double x = 1; x < 3; x += h) {
            fun[i] = Math.exp(x) + z;
            i++;
        }

        for(int j = 0; j < fun.length; j++){
            min = fun[j];
            max = fun[j];
            for (int k = 0; k < fun.length; k++) {
                System.out.println(min);
                if (min > fun[k]) min = fun[k];
                if (max < fun[k]) max = fun[k];
            }
        }

        System.out.println("Таблица: ");
        System.out.println(" ______________________");
        System.out.println("| №|  x |  h |   f(x)   |");
        i = 0;
        for (double x = 1; x < 3; x += h) {
                if(max == fun[i]) {
                    System.out.format("|%3d|%4.2f|%4.1f|", (i+1), x, h);
                    System.out.print("/" + "\\");
                    System.out.format("%9.5f|\n", fun[i]);
                } else if (min == fun[i]) {
                    System.out.format("|%3d|%4.2f|%4.1f|", (i+1), x, h);
                    System.out.print("\\" + "/");
                    System.out.format("%9.5f|\n", fun[i]);
                } else System.out.format("|%3d|%4.2f|%4.1f|%11.5f|\n", (i+1), x, h, fun[i]);
            i++;
        }
    }
}
