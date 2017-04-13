package SSP.LabWork2;


public class Task2 {
    
    public static double[][] transpose(double[][] matrix) {
        double trans[][] = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                trans[i][j] = matrix[j][i];
            }
        }
        return trans;
    }

    public static void main(String[] args) {
        double matrix[][] = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }

        System.out.println("Матрица: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        matrix = transpose(matrix);

        System.out.println("Транспонированная матрица: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
