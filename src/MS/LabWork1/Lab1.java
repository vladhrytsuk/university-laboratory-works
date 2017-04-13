package MS.LabWork1;

public class Lab1 {

    public static void main(String[] args) {
        Random ob = new Random(1, 1, 5000, 400000, 900009);
        long count = 0;

        ob.firstRand(ob.Z0, ob. Z1);

        while (true) {
            ob.Rand(ob.Z0, ob.Z1);
            count++;
            if (ob.firstZ0 == ob.Z0 && ob.firstZ1 == ob.Z1)  {
                System.out.println("Период: " + count);
                break;
            }
        }

    }
}
