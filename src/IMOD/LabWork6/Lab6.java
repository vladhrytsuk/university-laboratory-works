package IMOD.LabWork6;
import java.util.Arrays;
import java.util.Scanner;

public class Lab6 {
    public int firstVector[] = {0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1};
    public int secondVector[] = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
    public int thirdVector[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 3};
    public double w1[];
    public double w2[];
    public double w3[];
    public double T, S, Y, a, t, D[];
    public int step;

    Lab6() {
        this.t = 1;
        this.T = 0;
        this.S = 0;
        this.Y = 0;
        this.step = 0;
        this.D = new double[3];
        this.w1 = new double[20];
        this.w2 = new double[20];
        this.w3 = new double[20];
    }

    public void teachingFunction(int x1[], int x2[], int x3[]) {


        for (int i = 0; i < 20; i++) {
            w1[i] = 0;
            w2[i] = 0;
            w3[i] = 0;
        }

        t = 1;


        while (t <= 250) {

            for (int i = 0; i < 3; i++) {
                D[i] = 0;
            }

            step++;

            a = (double)1/t;

            for (int i = 0; i < 20; i++) {
                D[0] += Math.abs(x1[i] - w1[i]);
                D[1] += Math.abs(x2[i] - w2[i]);
                D[2] += Math.abs(x3[i] - w3[i]);
            }

            System.out.print("Step [" + step + "], D1: " + D[0] + ", D2: " + D[1]+ ", D3: " + D[2] );
            Arrays.sort(D);
            double minD = D[0];
            double maxD = D[2];

            System.out.print(", w: ");
            for (int i = 0; i < 20; i++) {
                if(D[0] == maxD) {
                    w1[i] = w1[i] + a * (x1[i] - w1[i]);
                } else if (D[1] == maxD) {
                    w2[i] = w2[i] + a * (x2[i] - w2[i]);
                } else if (D[2] == maxD) {
                    w3[i] = w3[i] + a * (x3[i] - w3[i]);
                } else {
                    w1[i] = w1[i];
                    w2[i] = w2[i];
                    w3[i] = w3[i];
                }
            }

            for (int i = 0; i < 20; i++) {
                if (D[0] == minD) {
                    System.out.print(w1[i] + " ");
                } else if (D[1] == minD) {
                    System.out.print(w2[i] + " ");
                } else if (D[2] == minD) {
                    System.out.print(w3[i] + " ");
                }
            }

            System.out.println();

            t++;
        }

    }

    public void test(int x[]) {
        double D1 = 0, D2 = 0, D3 = 0;

        for (int i = 0; i < 20; i++) {
            D[0] += Math.abs(x[i] - w1[i]);
            D[1] += Math.abs(x[i] - w2[i]);
            D[2] += Math.abs(x[i] - w3[i]);
        }

        D1 = D[0]; D2 = D[1]; D3 = D[2];
        Arrays.sort(D);
        if (D[0] == D1) {
            System.out.println( "1" );
        } else if (D[0] == D2) {
            System.out.println("2");
        } else if (D[0] == D3) {
            System.out.println("3");
        }

        System.out.println( "D = " + D1 + ", " + D2 + ", " + D3 );
    }

    public static void main(String[] args) {
        Lab6 ob = new Lab6();
        Scanner in = new Scanner(System.in);

        System.out.println("Teaching...");
        ob.teachingFunction(ob.firstVector, ob.secondVector, ob.thirdVector);
        System.out.println("Completed...");

        System.out.print("Enter count:");
        int count = in.nextInt();
        int mas[] = new int[count];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = in.nextInt();
        }

        ob.test(mas);
    }
}