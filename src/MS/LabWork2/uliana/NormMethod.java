package MS.LabWork2.uliana;

import java.util.Scanner;

public class NormMethod {

    public static void multiplnorm(int a) {
        double r = 0, dis_m = 0, dis_e = 0, mat_m = 0, mat_e = 0;
        double l9m = 1539, x = 25, l9mx = l9m * x, x1 = 0;
        double arr[] = new double[30000];
        double arr2[] = new double[6000];
        int k = 0;

        if(a % 6 != 0) {
            a = a - a % 6;
        }

        System.out.format("| %5s || %7s || %7s |\n", "#", "Конгр.", "Эксп.");

        for(int j = 0; j < a; j++) {
            for(int i = 0; i < 10; i++) {
                x1 = x1 + l9mx%2 * Math.pow(2, i);
                l9mx = (l9mx - l9mx % 2)/2;
            }

            l9mx = l9m * x1;
            arr[j] = x1 / Math.pow(2, 10);
            mat_m += arr[j];
            x1 = 0;
        }

        for(int j = 0; j < a; j += 6) {
            for(int i = 0; i < 6; i++){
                r += arr[j+i];
            }

            arr2[k] = 2 + 12 * Math.sqrt(2) * (r - 3);

            System.out.format("| %5d || %7.4f || %7.4f |\n", (k + 1), arr[k], arr2[k]);
            mat_e += arr2[k];
            k++;
            r = 0;
        }
        a = k;

        mat_m /= a;
        mat_e /= a;

        System.out.format("%25s %7.6f || %7.6f\n", "Математическое ожидание:", mat_m, mat_e);

        for(int j = 0; j < a; j++) {
            dis_m += Math.pow((arr[j] - mat_m), 2);
            dis_e += Math.pow((arr2[j] - mat_e), 2);
        }

        System.out.format("%11s %7.6f || %7.6f\n", "Дисперсия:", dis_m / (a - 1), dis_e / (a - 1));
        System.out.format("%35s %7.6f || %7.6f\n", "Среднее квадратическое отклонение:", Math.pow(dis_m / (a - 1) / a, 0.5), Math.pow(dis_e / (a - 1) / a, 0.5));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер выборки: ");
        int n = in.nextInt();
        multiplnorm(n);
    }

}
