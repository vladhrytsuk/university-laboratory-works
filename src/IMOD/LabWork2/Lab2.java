package IMOD.LabWork2;

public class Lab2 {
    public double w1, w2, w3, s_a = 0.5f, y, T, E = 1, Em = 0.001f, d = 0.1f;

    public int i = 0, a = 1, b = 5;

    public void WidwowHoffa(double x1, double x2, double x3, double t) {
        y = (w1 * x1) + (w2 * x2) + (w3 * x3) - T;
        E = 0.5 * (Math.pow(y - t, 2));
        w1 = w1 - s_a * x1 * (y - t);
        w2 = w2 - s_a * x2 * (y - t);
        w3 = w3 - s_a * x3 * (y - t);
        T = T + s_a * (y - t);
        y = (w1 * x1) + (w2 * x2) + (w3 * x3) - T;
        E = 0.5 * (Math.pow(y - t, 2));

        System.out.println("Step " + (i + 1) + ": w1 = " + w1 + ", w2 = " + w2 + ", w3 = " + w3 + ", T = " + T + ", y = " + y);
        i++;

    }

    public static void main(String[] args) {
        Lab2 ob = new Lab2();
        double y[]  = new double[10];
        double E = 1d, result;

        for (int i = 0; i < 7; i++) {
            y[i] = ob.a * Math.sin(ob.b * i * ob.s_a) + ob.d;
            System.out.println("y [" + (i+1) + "] = " + y[i]);
        }

        while (ob.Em <= E) {
            System.out.println();
            for (int i = 0; i < 3; i++) {
                System.out.println("Complete " + (i + 1) + " study");
                ob.WidwowHoffa(y[i], y[i+1], y[i+2], y[i+3]);
            }

            E = 0.5 * (Math.pow(y[3] - ((ob.w1 * y[0]) + (ob.w2 * y[1]) + (ob.w3 * y[2]) - ob.T), 2) +
                    Math.pow(y[4] - ((ob.w1 * y[1]) + (ob.w2 * y[2]) + (ob.w3 * y[3]) - ob.T), 2) +
                    Math.pow(y[5] - ((ob.w1 * y[2]) + (ob.w2 * y[3]) + (ob.w3 * y[4]) - ob.T), 2));

            System.out.println("E = " + E);
        }

        result = (ob.w1 * y[3]) + (ob.w2 * y[4]) + (ob.w3 * y[5]) - ob.T;

        System.out.println();
        System.out.println("Result: " + result + " ≈ " + y[6]);

    }
}
