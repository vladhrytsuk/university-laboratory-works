package SSP.LabWork2.variant8.kirill;


public class Task2 {
    
    public static void add(double[] array, int index, double element) {
        if (index > array.length) {
            System.err.println("Нет такой позиции в массиве.");
        } else {
            array[index - 1] = element;
        }
    }

    public static void main(String[] args) {
        double array[] = {1, 2, 4, 5, 6};

        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        add(array, 4, 7);

        System.out.print("\nМассив с добавленным элементом: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
