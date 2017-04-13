package MS.LabWork2;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        QuasiOfNumber quasiOfNumber = new QuasiOfNumber(1, 1, 5000, 400000, 900009);
        ServiceMethods serviceMethods = new ServiceMethods();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер выборки: ");
        int count = in.nextInt();

        double quasiArray[] = new double[count];

        for (int i = 0; i < quasiArray.length; i++) {
            quasiArray[i] = quasiOfNumber.recursionMethod(quasiOfNumber.Z0, quasiOfNumber. Z1);
        }

        System.out.println(
                "1 - Равномерное распределение;\n" +
                "2 - Нормальное распределение;\n" +
                "3 - Экспоненциальное распределение;\n" +
                "4 - Треугольное распределение;\n"
        );

        System.out.print("Выберите метод: ");
        int methods = in.nextInt();

        switch (methods) {
            case 1:
                serviceMethods.evenDistribution(count, quasiArray, -3, 7);
                break;
            case 2:
                serviceMethods.normalDistribution(count, quasiArray, 5.6, 0.02);
                break;
            case 3:
                serviceMethods.exponentialDistribution(count, quasiArray, 0.8);
                break;
            case 4:
                serviceMethods.triangularDistribution(count, quasiArray, -5, 15);
                break;
            default:
                System.err.println("Извините такого метода нет.");
        }
    }
}
