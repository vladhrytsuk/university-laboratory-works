package MS.LabWork2;

public interface IServiceMethods {
    void evenDistribution(int count, double[] Ri, int a, int b);
    void normalDistribution(int count, double[] Ri, double m, double a);
    void exponentialDistribution(int count, double[] Ri, double la);
    void triangularDistribution(int count, double[] Ri, int a, int b);
}
