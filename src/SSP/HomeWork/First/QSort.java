package SSP.HomeWork.First;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QSort {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("Введите кол-во чисел: ");
        int count = in.nextInt();

        System.out.print("List: ");
        for (int i = 0; i < count; i++) {
            array.add((int)(Math.random() * count));
            System.out.print(array.get(i) + " ");
        }

        qSort(array);

        System.out.print("\nОтсортированный List: ");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static void qSort(List<Integer> array) {
        int n = array.size();
        int i = 0;
        int j = n-1;
        int x = array.get((int)(Math.random() * n));
        while (i <= j) {
            while (array.get(i) < x) {
                i++;
            }
            while (array.get(j) > x) {
                j--;
            }
            if (i <= j) {
                Collections.swap(array,i,j);
                i++;
                j--;
            }
        }
        if (j>0){
            qSort(array.subList(0, j + 1));
        }
        if (i<n){
            qSort(array.subList(i,n));
        }
    }

}
