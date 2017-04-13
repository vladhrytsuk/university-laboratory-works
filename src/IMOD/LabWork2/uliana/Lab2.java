package IMOD.LabWork2.uliana;

import java.util.ArrayList;

public class Lab2 {
    public double alpha = 0.01, Emin = 0.01, E = 0, T = 0;
    public double enters[] = new double[4];
    public double weights[] = new double[enters.length];
    public double etalons[] = new double[30];
    public double y[] = new double[27];
    ArrayList<Double> predicts = new ArrayList<>();
    ArrayList<Double> tmp = new ArrayList<>();

    public void init() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random()*0.2+0.1;
        }
        T = Math.random()*0.2+0.1;
    }

    public void initEtalons() {
        for (int i = 0; i < etalons.length; i++) {
            etalons[i] = 4 * Math.sin(7*i) + 0.2;
        }
    }

    public void count(){
        do {
            E = 0;

            for (int i = 0; i < etalons.length - enters.length; i++) {
                y[i] = 0;

                for (int j = 0; j < enters.length; j++) {
                    y[i] += weights[j] * etalons[i+j];
                }
                y[i] -= T;

                for (int j = 0; j < enters.length; j++) {
                    weights[j] -= alpha * (y[i] - etalons[i + enters.length]) * etalons[i+j];
                }

                T += alpha * (y[i] - etalons[i+enters.length]);
            }

            for (int i = 0; i < etalons.length - enters.length; i++) {
                y[i] = 0;

                for (int j = 0; j < enters.length; j++) {
                    y[i] +=  weights[j] * etalons[i+j];
                }

                y[i] -= T;
                E += 0.5 * Math.pow((y[i] - etalons[i + enters.length]),2);
            }
        } while(E > Emin);
    }

    public void perdict(){
        for (int i = 0; i < y.length; i++ ) {
            tmp.add(y[i]);
        }

        for(int k = 0; k < 15; k++){
            double x = 0;

            for (int i = tmp.size() - enters.length; i < tmp.size() - 3; i++) {

                for (int j = 0; j < enters.length; j++ ) {
                    x += weights[j] * tmp.get(i+j);

                }

                predicts.add(x);

            }

            tmp.add(x);
        }
    }


    public void show(){
        System.out.println("Etalons \t\t\t\t Learning");
        for (int i = 0; i < etalons.length; i++) {
            if(i > 3){
                System.out.println(etalons[i] + "\t\t\t" + y[i-4]);
            }
            else{
                System.out.println(etalons[i]);
            }
        }

        System.out.println("Predicts");

        for (int i = 0; i < predicts.size(); i++ ) {
            System.out.println(predicts.get(i));
        }
    }

    public static void main(String[] args) {
        Lab2 ob = new Lab2();
        System.out.println("Лабораторная работа №2 ИМОД");
        ob.init();
        ob.initEtalons();
        ob.count();
        ob.perdict();
        ob.show();
    }
}
