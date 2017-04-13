package SSP.HomeWork.First;

import java.util.Random;

public class SortBubble {

    public static void main(String[] args) {
        Random rand = new Random();
        Integer arr[] = new Integer[10];

        System.out.print("Последовательность чисел: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + "  ");
        }

        System.out.print("\nСортировка последовательности: ");
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for(int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}



