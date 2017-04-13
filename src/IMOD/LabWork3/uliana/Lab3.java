package IMOD.LabWork3.uliana;


import java.util.ArrayList;

public class Lab3 {
    public double alpha = 0.005, Emin = 0.005, E = 0, T = 0, epoch = 0;
    public double enters[] = new double[4];
    public double weights[] = new double[enters.length];
    public double etalons[] = new double[70];
    public double y[] = new double[etalons.length - 3];
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

    public void count() {
        double out = 0;
        do {
            E = 0;
            epoch++;
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
                E += Math.pow((y[i] - etalons[i + enters.length]), 2);
                out += Math.pow(y[i], 2);
            }

            for (int i = 0; i < etalons.length - enters.length; i++) {
                y[i] = 0;

                for (int j = 0; j < enters.length; j++) {
                    y[i] +=  weights[j] * etalons[i+j];
                }

                y[i] -= T;
                alpha = 1/(1+out);
            }

            out = 0;
            System.out.println(E);
        } while(E/2 > Emin);

        System.out.println("Epoch: " + epoch);
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
    }

    public static void main(String[] args) {
        Lab3 ob = new Lab3();
        System.out.println("Лабораторная работа №3 ИМОД");
        ob.init();
        ob.initEtalons();
        ob.count();
        ob.perdict();
        ob.show();
    }
}
