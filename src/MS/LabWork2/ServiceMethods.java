package MS.LabWork2;

public class ServiceMethods implements IServiceMethods{

    @Override
    public void evenDistribution(int count, double[] Ri, int a, int b) {
        double dis_m = 0, dis_e = 0, mat_m = 0, mat_e = 0, newRi[] = new double[count];

        System.out.format("| %5s || %7s || %7s |\n", "#", "Конгр.", "Эксп.");

        for (int i = 0; i < count; i++) {
            mat_m += Ri[i];
        }

        for (int i = 0; i < count; i++) {
            newRi[i] = a + (b - a) * Ri[i];

            System.out.format("| %5d || %7.4f || %7.4f |\n", (i + 1), Ri[i], newRi[i]);

            mat_e += newRi[i];
        }

        mat_m /= count;
        mat_e /= count;

        System.out.format("%25s %7.6f || %7.6f\n", "Математическое ожидание:", mat_m, mat_e);

        for(int j = 0; j < count; j++) {
            dis_m += Math.pow((Ri[j] - mat_m), 2);
            dis_e += Math.pow((newRi[j] - mat_e), 2);
        }

        System.out.format("%11s %7.6f || %7.6f\n", "Дисперсия:", dis_m/(count - 1), dis_e/(count - 1));
        System.out.format("%35s %7.6f || %7.6f\n", "Среднее квадратическое отклонение:", Math.pow(dis_m/(count - 1) / count, 0.5), Math.pow(dis_e/(count - 1)/count, 0.5));
    }

    @Override
    public void normalDistribution(int count, double[] Ri, double m, double a) {
        double r = 0, dis_m = 0, dis_e = 0, mat_m = 0, mat_e = 0, newRi[] = new double[count];
        int k = 0;

        if(count % 6 != 0) {
            count = count - count % 6;
        }

        System.out.format("| %5s || %7s || %7s |\n", "#", "Конгр.", "Эксп.");

        for (int i = 0; i < count; i++) {
            mat_m += Ri[i];
        }

        for (int i = 0; i < count; i += 6) {
            for (int j = 0; j < 6; j++) {
                r += Ri[i+j];
            }

            newRi[k] = m + a * Math.sqrt(2) * (r - 3);

            System.out.format("| %5d || %7.4f || %7.4f |\n", (k + 1), Ri[k], newRi[k]);

            mat_e += newRi[k];
            k++;
            r = 0;
        }

        count = k;

        mat_m /= count;
        mat_e /= count;

        System.out.format("%25s %7.6f || %7.6f\n", "Математическое ожидание:", mat_m, mat_e);

        for(int j = 0; j < count; j++) {
            dis_m += Math.pow((Ri[j] - mat_m), 2);
            dis_e += Math.pow((newRi[j] - mat_e), 2);
        }

        System.out.format("%11s %7.6f || %7.6f\n", "Дисперсия:", dis_m/(count - 1), dis_e/(count - 1));
        System.out.format("%35s %7.6f || %7.6f\n", "Среднее квадратическое отклонение:", Math.pow(dis_m/(count - 1) / count, 0.5), Math.pow(dis_e/(count - 1)/count, 0.5));
    }

    @Override
    public void exponentialDistribution(int count, double[] Ri, double la) {
        double dis_m = 0, dis_e = 0, mat_m = 0, mat_e = 0, newRi[] = new double[count];

        System.out.format("| %5s || %7s || %7s |\n", "#", "Конгр.", "Эксп.");

        for (int i = 0; i < count; i++) {
            mat_m += Ri[i];
        }

        for (int i = 0; i < count; i++) {
            newRi[i] = -(1/la) * Math.log10(Ri[i]);

            System.out.format("| %5d || %7.4f || %7.4f |\n", (i + 1), Ri[i], newRi[i]);

            mat_e += newRi[i];
        }

        mat_m /= count;
        mat_e /= count;

        System.out.format("%25s %7.6f || %7.6f\n", "Математическое ожидание:", mat_m, mat_e);

        for(int j = 0; j < count; j++) {
            dis_m += Math.pow((Ri[j] - mat_m), 2);
            dis_e += Math.pow((newRi[j] - mat_e), 2);
        }

        System.out.format("%11s %7.6f || %7.6f\n", "Дисперсия:", dis_m/(count - 1), dis_e/(count - 1));
        System.out.format("%35s %7.6f || %7.6f\n", "Среднее квадратическое отклонение:", Math.pow(dis_m/(count - 1) / count, 0.5), Math.pow(dis_e/(count - 1)/count, 0.5));
    }

    @Override
    public void triangularDistribution(int count, double[] Ri, int a, int b) {
        double dis_m = 0, dis_e = 0, mat_m = 0, mat_e = 0, newRi[] = new double[count];

        System.out.format("| %5s || %7s || %7s |\n", "#", "Конгр.", "Эксп.");

        for (int i = 0; i < count; i++) {
            mat_m += Ri[i];
        }

        for (int i = 0; i < count; i++) {
            if(i == count - 1) {
                newRi[i] = a + (b - a) * Ri[i];
            } else {
                newRi[i] = a + (b - a) * Math.max(Ri[i], Ri[i+1]);
            }

            System.out.format("| %5d || %7.4f || %7.4f |\n", (i + 1), Ri[i], newRi[i]);

            mat_e += newRi[i];
        }

        mat_m /= count;
        mat_e /= count;

        System.out.format("%25s %7.6f || %7.6f\n", "Математическое ожидание:", mat_m, mat_e);

        for(int j = 0; j < count; j++) {
            dis_m += Math.pow((Ri[j] - mat_m), 2);
            dis_e += Math.pow((newRi[j] - mat_e), 2);
        }

        System.out.format("%11s %7.6f || %7.6f\n", "Дисперсия:", dis_m/(count - 1), dis_e/(count - 1));
        System.out.format("%35s %7.6f || %7.6f\n", "Среднее квадратическое отклонение:", Math.pow(dis_m/(count - 1) / count, 0.5), Math.pow(dis_e/(count - 1)/count, 0.5));
    }
}
