package MS.LabWork2;

public class QuasiOfNumber {

    public int a0, a1, M, Z, x, Z0, Z1;
    public double x1;
    public static int count;

    public QuasiOfNumber(int a0, int a1, int M, int Z0, int Z1) {
        this.a0 = a0;
        this.a1 = a1;
        this.M = M;
        this.Z0 = Z0;
        this.Z1 = Z1;
        count = 0;
    }

    public double recursionMethod(int Z0, int Z1) {
        Z = a0 * Z0 + a1 * Z1;

        if (Z < 0) {
            Z += Integer.MAX_VALUE + 1;
        }

        x = Z % M;
        x1 = (double)x / M;

        this.Z0 = Z1;
        this.Z1 = Z;

        count++;
        return x1;
    }
}
