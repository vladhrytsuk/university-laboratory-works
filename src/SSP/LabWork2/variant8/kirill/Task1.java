package SSP.LabWork2.variant8.kirill;

public class Task1 {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 1, 0, 0, 7} ;
        String buf = "";
        int k = a[0] + 1;

        for(int i = 1; i < a.length; i++){
            if(a[i] == k) {
                k++;
            } else if (a[i] != k) {
                buf += a[i];
            }
        }

        System.out.print("Массив: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println("\nВыброс: " + buf);
    }
}
