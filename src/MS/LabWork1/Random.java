package MS.LabWork1;

public class Random {

    public int a0, a1, M, Z, x, firstZ0, firstZ1, Z0, Z1;
    public double x1;
    public static int count;

    Random(int a0, int a1, int M, int Z0, int Z1) {
        this.a0 = a0;
        this.a1 = a1;
        this.M = M;
        this.Z0 = Z0;
        this.Z1 = Z1;
        count = 0;
    }

    public double Rand (int Z0, int Z1) {
        Z = a0 * Z0 + a1 * Z1;
        if (Z < 0) {
            Z += Integer.MAX_VALUE + 1;
        }
        x = Z % M;
        x1 = (double)x / M;
        //System.out.println((count + 1) + ": " + " Z1: " + Z1 + " Z2: " + Z + " f(x): " + x1);

        this.Z0 = Z1;
        this.Z1 = Z;

        count++;
        return x1;
    }

    public void firstRand(int Z0, int Z1) {
        Z = a0 * Z0 + a1 * Z1;

        if (Z < 0) {
            Z += Integer.MAX_VALUE + 1;
        }

        x = Z % M;
        x1 = (double)x / M;

        firstZ0 = Z1;
        firstZ1 = Z;

        this.Z0 = Z1;
        this.Z1 = Z;
    }

}
