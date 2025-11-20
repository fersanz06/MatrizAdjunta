import java.util.Scanner;

public class MatrizAdjunta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño: ");
        int n = sc.nextInt();

        double[][] m = new double[n][n];

        System.out.println("Valores:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextDouble();
            }
        }

        double[][] adj = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = Math.pow(-1, i + j + 1);
            }
        }

        imprimir(adj);
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
