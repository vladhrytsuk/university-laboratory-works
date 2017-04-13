package SSP.HomeWork.First;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortDecrease {

    public static void main(String[] args) {
        Random rand = new Random();
        Integer arr[] = new Integer[10];

        System.out.print("Последовательность чисел: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + "  ");
        }

        System.out.print("\nСортировка последовательности: ");
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

}
