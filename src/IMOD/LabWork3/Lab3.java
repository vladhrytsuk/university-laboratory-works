package IMOD.LabWork3;

import java.util.Scanner;

public class Lab3 {

    public double T = 0, S = 0, w1 = 0, w2 = 0, a, Y = 0;
    public boolean live = true;
    public int count = 0;
    public int i = 0;

    public void printTest (int x, int y, int e) {
        a = 1 / (1 + Math.pow(x, 2) + Math.pow(y, 2));

        S = (w1 * x + w2 * y) - T;

        if (S > 0) {
            Y = 1;
        } else if (S < 0) {
            Y = 0;
        }

        while (e != Y) {
            w1 = w1 - (a * x * (Y - e));
            w2 = w2 - (a * y * (Y - e));
            T = T + a * (Y - e);
            S = (w1 * x + w2 * y) - T;

            if (S > 0) {
                Y = 1;
            } else if (S < 0) {
                Y = 0;
            }
        }


        System.out.println("Шаг " + (i + 1) + ": w1 = " + w1 + ", w2 = " + w2 + ", T = " + T + ", S = " + S + ", Y = " + Y);
        i++;

        if (i > 3){
            i = 0;
        }

    }


    public static void main(String[] args) {
        int x[] = {1, -1, -1, 1},
                y[] = {1, 1, -1, -1},
                e[] = {0, 0, 0, 1};

        Lab3 ob = new Lab3();

        while(ob.live) {
             ob.count = 0;

            for (int i = 0; i < 4; i++) {
                ob.printTest(x[i], y[i], e[i]);
                ob.S = (ob.w1 * x[i] + ob.w2 * y[i]) - ob.T;

                if (ob.S > 0) {
                    ob.Y = 1;
                } else if (ob.S < 0) {
                    ob.Y = 0;
                }

                if (ob.Y == e[i]) {
                    ob.count++;
                }

                if (ob.count == 4) {
                    ob.live = false;
                    break;
                }
            }
        }

        Scanner in = new Scanner( System.in );
        System.out.print("Введите x: ");
        int ex = in.nextInt();
        System.out.print("Введите y: ");
        int ey = in.nextInt();
        ob.S = (ob.w1 * ex + ob.w2 * ey) - ob.T;
        if (ob.S > 0) {
            ob.Y = 1;
        } else if (ob.S < 0) {
            ob.Y = 0;
        }
        System.out.println("Y = " + ob.Y);
        in.close();

    }

}


