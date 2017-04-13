package SSP.LabWork2.variant8.uliana;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        /*
        * Создаём объект класса Scanner.
        *
        * Для работы с потоком ввода необходимо создать объект класса Scanner,
        * при создании указав, с каким потоком ввода он будет связан. Стандартный
        * поток ввода (клавиатура) в Java представлен объектом — System.in.
        *
        * */
        Scanner in = new Scanner(System.in);
        int lengthOfElements = 0; // Создаем переменную для определния количества элементов в последовательности.

        System.out.print("Enter size of sequence: ");
        /*Если мы вводим число, то с потока ввода записываем данные в нашу переменную для кол-ва элементов.*/
        if(in.hasNextInt()) {
            lengthOfElements = in.nextInt();
            /*Иначе, если мы ввели что-то другое, выведится сообщение о том, что введено не число типа int.*/
        } else {
            System.err.println("Error: you entered is not a number of type INT!");
        }

        /*Объявляем нашу последовательность чисел, указывая к квадратных скобках нашу переменную, которая будет
        * определять длинну нашей последовательности.
        * */
        int sequenceOfElements[] = new int[lengthOfElements];

        System.out.println("Enter sequence of elements: ");
        /*Проходит по каждому эдементов массива, тем самым инициализируя каждый элемент нашей последовательности,
        * Мы вводим с клавиатуры числа, через пробел, или каждое число нажимая Enter
        * */
        for (int i = 0; i < sequenceOfElements.length; i++) {
            /*Если мы дошли до конца нашего массива ввод прекращается,
            * об этом говорит break;
            * */
            if (i == sequenceOfElements.length) {
                break;
            }
            /*Инициализируем с потока ввода нашу последовательность, для каждого элемента*/
            sequenceOfElements[i] = in.nextInt();
        }

        String ejection = ""; // Создаем переменную, для того чтобы записать наш выброс
        int nextElement = sequenceOfElements[0] + 1; // Создаем переменную которая обозначает следующий элемент

        /*Проходим по нашей последовательности начиная со 2 элемента последовательности
        * потому, что первый элемент нам не интересен
        * */
        for(int i = 1; i < sequenceOfElements.length; i++){
            System.out.println("a[" + i + "]: "  + sequenceOfElements[i]);
            System.out.println("nextElement: " + nextElement);
            /*Если наш элемент равен следующему элементу, значит последовательность сохраняется, и мы идём дальше*/
            if(sequenceOfElements[i] == nextElement) {
                nextElement++;
                continue;
                /*Иначе, если наш элемент не равен следующему элементу, значит последовательность нарушена,
                * что говорит нам об выбросе, который мы как раз и записываем
                * */
            } else if (sequenceOfElements[i] != nextElement) {
                ejection += sequenceOfElements[i];
            }
        }

        /*Выводим всю нащу последовательность*/
        System.out.print("Sequence Of Elements: ");
        for (int i = 0; i < sequenceOfElements.length; i++) {
            System.out.print(sequenceOfElements[i]);
        }

        /*Выводим наш выброс*/
        System.out.println("\nEjection: " + ejection);
    }
}
