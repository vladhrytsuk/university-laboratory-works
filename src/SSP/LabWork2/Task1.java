package SSP.LabWork2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int average = 0;
        double d = 0;
        double temp = 0;

        System.out.print("Введите кол-во чисел: ");

        if(in.hasNextInt()) {
            count = in.nextInt();
        } else {
            System.err.println("Введены некоректные данные!");
        }

        int mas[] = new int[count];


        for (int i = 0; i < count; i++) {
            mas[i] = (int)(Math.random() * count);
            average += mas[i];
        }

        average /= count;

        System.out.print("Массив: ");
        for (int i = 0; i < count; i++) {
            System.out.print(mas[i] + " ");
        }

        for (int i = 0; i < count; i++) {
            temp += mas[i] - average;
        }

        d = Math.sqrt(Math.sqrt(temp)/(count - 1));


        System.out.println("\nСреднее значение: " + average);
        System.out.println("Дисперсия: " + d);
    }
}
