package IMOD.LabWork4;

import java.util.Scanner;

public class Lab4 {

    public int firstVector[] = {0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1};
    public int secondVector[] = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
    public int thirdVector[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 3};
    public double v[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public double S = 0, T = 0, a = 0;
    public int step = 0;

    Lab4 () {
        this.a = 0.1;
    }

    public void print (int x[]) {
        S = 0;

        for (int i = 0; i < 20; i++) {
            S += v[i] * x[i];
        }

        S -= T;

        while ( x[20] != Math.round(S)) {
            S = 0;

            step++;

            for (int i = 0; i < 20; i++) {
                v[i] = v[i] - a * x[i] * (S - x[20]);
                S += v[i] * x[i];
            }

            T = T + a * (S - x[20]);
            S -= T;

            System.out.println("Step [" + step + "], T: " + T + ", S: " + S + ", vector: " + x[20]);
            System.out.print("v: ");
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i] + " ");
            }
            System.out.println("\n");
        }

    }

    public void test(int x[]) {
        S = 0;

        for (int i = 0; i < 20; i++) {
            S += v[i] * x[i];
        }

        S -= T;

        System.out.println("S: " + Math.round(S));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Lab4 ob = new Lab4();
        for (int i = 0; i < 100; i++) {
            ob.print(ob.firstVector);
            ob.print(ob.secondVector);
            ob.print(ob.thirdVector);
        }

        System.out.print("Enter count:");
        int count = in.nextInt();
        int mas[] = new int[count];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = in.nextInt();
        }

        ob.test(mas);

    }
}
