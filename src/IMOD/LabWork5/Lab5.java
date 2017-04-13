package IMOD.LabWork5;

import java.util.Random;
import java.util.Scanner;

public class Lab5 {

    public int firstVector[] = {0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1};
    public int secondVector[] = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
    public int thirdVector[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 3};
    public double w1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public double w[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public double T, S, Y, a;
    public int step;

    Lab5() {
        a = 0.3;
        T = 0; S = 0; Y = 0;
        step = 0;
    }

    void teachingFunction(int x[]) {
        S = 0;

        for ( int i = 0; i < 20; i++) {
            S += (w[i] * x[i]);
        }

        S -= T;

        while ( x[20] != Math.round(S)) {
            S = 0;

            step++;

            for (int i = 0; i < 20; i++) {
                w[i] = w[i] - a * x[i] * (S - x[20]);
                S += (w[i] * x[i]);
            }

            T = T + a * (S - x[20]);
            S -= T;

            System.out.println( "Step " + step + ": ");

            for (int i = 0; i < 20; i++) {
                System.out.print( "w" + i + " = " + w[i] + ", ");
            }
            System.out.println( "T = " + T + ",S = " + S + ", Number = " + x[20]);
        }
    }

    void hopfieldFunction(int x1[], int x2[], int x3[], double w1[]) {
        Random r = new Random();
        double Ti = 0;

        for ( int i = 0; i < 20; i++ ) {
            w1[i] = (2 * x1[i] - 1) * (2 * x1[20] - 1) + (2 * x2[i] - 1) * (2 * x2[20] - 1) +
                    (2 * x3[i] - 1) * (2 * x3[20] - 1);
        }

        int i = r.nextInt(20);
        Ti = x1[i] + x2[i] + x3[i];

        if (w1[i] * x1[20] + Ti >= 0) {
            x1[i] = 1;
        } else {
            x1[i] = 0;
        }

        if (w1[i] * x2[20] + Ti >= 0) {
            x2[i] = 1;
        } else {
            x2[i] = 0;
        }

        if (w1[i] * x3[20] + Ti >= 0) {
            x3[i] = 1;
        } else {
            x3[i] = 0;
        }

        System.out.println( "w = " + w1[i] + "  " + i);
    }


    public static void main(String[] args) {
        Lab5 ob = new Lab5();
        int i = 0;

        while (i != 100) {
            ob.teachingFunction(ob.firstVector);
            ob.teachingFunction(ob.secondVector);
            ob.teachingFunction(ob.thirdVector);
            i++;
        }

        ob.hopfieldFunction(ob.firstVector, ob.secondVector, ob.thirdVector, ob.w1);

        System.out.print( "Number: " );
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int array[] = new int[count];


        for (int j = 0; j < array.length; j++) {
            array[j] = in.nextInt();
        }

        ob.S = 0;

        for ( int k = 0; k < 20; k++) {
            ob.S += (ob.w[k] * array[k]);
        }

        ob.S -= ob.T;

        System.out.println( "S = " + Math.round(ob.S));
    }
}
