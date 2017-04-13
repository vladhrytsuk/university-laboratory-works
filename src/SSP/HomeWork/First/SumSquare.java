package SSP.HomeWork.First;

import java.util.Scanner;

public class SumSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите кол-во чисел: ");
        int count = in.nextInt();
        int mas[] = new int[count];
        int sum = 0;

        for (int i = 0; i < count; i++) {
            mas[i] = (int)(Math.random() * count);
            sum += mas[i] * mas[i];
        }

        System.out.print("Массив: ");
        for (int i = 0; i < count; i++) {
            System.out.print(mas[i] + " ");
        }

        System.out.println("\nСумма: " + sum);
    }

}
