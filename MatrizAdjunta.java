import java.util.Scanner;

public class MatrizAdjunta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño: ");
        int n = sc.nextInt();

        double[][] m = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextDouble();
            }
        }

        double[][] adj = adjunta(m);

        imprimir(adj);
    }

    public static double[][] adjunta(double[][] m) {
        int n = m.length;
        double[][] cof = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double d = determinante(sub(m, i, j));
                cof[i][j] = Math.pow(-1, i + j) * d;
            }
        }

        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[j][i] = cof[i][j];
            }
        }

        return a;
    }

    public static double[][] sub(double[][] m, int f, int c) {
        int n = m.length;
        double[][] r = new double[n - 1][n - 1];
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (i == f) continue;
            int b = 0;
            for (int j = 0; j < n; j++) {
                if (j == c) continue;
                r[a][b] = m[i][j];
                b++;
            }
            a++;
        }
        return r;
    }

    public static double determinante(double[][] m) {
        int n = m.length;
        if (n == 1) return m[0][0];
        if (n == 2) return m[0][0] * m[1][1] - m[0][1] * m[1][0];
        double d = 0;
        for (int j = 0; j < n; j++) {
            d += Math.pow(-1, j) * m[0][j] * determinante(sub(m, 0, j));
        }
        return d;
    }

    public static void imprimir(double[][] m) {
        for (double[] f : m) {
            for (double v : f) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}