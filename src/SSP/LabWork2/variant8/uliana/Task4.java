package SSP.LabWork2.variant8.uliana;

public class Task4 {
    public static void main(String[] args) {
        double h = 0.01, min = 0, max = 0;
        String table[] = {"№", "x", "h", "f(x)"};
        int length = 0, i = 0;

        for (double x = -5; x < 15; x += h) {
            length++;
        }

        double fun[] = new double[length];

        for (double x = -5; x < 15; x += h) {
            fun[i] = 3 * Math.pow(x, 3) - 15 * Math.pow(x, 2) - 12 * x + 8;
            i++;
        }

        for(int j = 0; j < fun.length; j++){
            min = fun[j];
            max = fun[j];
            for (int k = 0; k < fun.length; k++) {
                if (min > fun[k]) min = fun[k];
                if (max < fun[k]) max = fun[k];
            }
        }

        System.out.println("Таблица: ");
        System.out.println(" _________________________________");
        System.out.format("|%-6s|%-6s|%-6s|%-11s|\n", "№", "x", "h", "f(x)");
        i = 0;
        for (double x = -5; x < 15; x += h) {
            if (fun[i] > 0) {
                if(max == fun[i]) {
                    System.out.format("|%6d|%6.2f|%6.2f|^ ^ %9.2f|\n", (i+1), x, h, fun[i]);
                } else if (min == fun[i]) {
                    System.out.format("|%6d|%6.2f|%6.2f|v v %9.2f|\n", (i+1), x, h, fun[i]);
                } else System.out.format("|%6d|%6.2f|%6.2f| %12.2f|\n", (i+1), x, h, fun[i]);
            }

            if (fun[i] < 0) {
                if(max == fun[i]) {
                    System.out.format("|%6d|%6.2f|%6.2f|^ ^%9.2f|\n", (i+1), x, h, fun[i]);
                } else if (min == fun[i]) {
                    System.out.format("|%6d|%6.2f|%6.2f|v v%9.2f|\n", (i+1), x, h, fun[i]);
                } else System.out.format("|%6d|%6.2f|%6.2f|%12.2f|\n", (i+1), x, h, fun[i]);
            }
            i++;
        }
    }
}
