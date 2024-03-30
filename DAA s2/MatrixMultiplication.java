import java.util.*;

public class MatrixMultiplication {
    public static void matrixmul(int[][] a, int[][] b, int n, int[][] c) {
        if (n <= 2) {
            c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
            c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
            c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
            c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        } else {
            int mid = n / 2;
            int[][] a11 = new int[mid][mid];
            int[][] a12 = new int[mid][mid];
            int[][] a21 = new int[mid][mid];
            int[][] a22 = new int[mid][mid];
            int[][] b11 = new int[mid][mid];
            int[][] b12 = new int[mid][mid];
            int[][] b21 = new int[mid][mid];
            int[][] b22 = new int[mid][mid];
            int[][] c11 = new int[mid][mid];
            int[][] c12 = new int[mid][mid];
            int[][] c21 = new int[mid][mid];
            int[][] c22 = new int[mid][mid];

            for (int i = 0; i < mid; i++) {
                for (int j = 0; j < mid; j++) {
                    a11[i][j] = a[i][j];
                    a12[i][j] = a[i][j + mid];
                    a21[i][j] = a[i + mid][j];
                    a22[i][j] = a[i + mid][j + mid];
                    b11[i][j] = b[i][j];
                    b12[i][j] = b[i][j + mid];
                    b21[i][j] = b[i + mid][j];
                    b22[i][j] = b[i + mid][j + mid];
                }
            }

            matrixmul(a11, b11, mid, c11);
            matrixmul(a12, b21, mid, c12);
            matrixmul(a21, b12, mid, c21);
            matrixmul(a22, b22, mid, c22);

            for (int i = 0; i < mid; i++) {
                for (int j = 0; j < mid; j++) {
                    c[i][j] = c11[i][j] + c12[i][j];
                    c[i][j + mid] = c21[i][j] + c22[i][j];
                    c[i + mid][j] = c11[i][j] + c12[i][j];
                    c[i + mid][j + mid] = c21[i][j] + c22[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4},
                     {5, 6, 7, 8}, 
                     {9, 10, 11, 12}, 
                     {13, 14, 15, 16}};
        int[][] b = {{17, 18, 19, 20}, 
                     {21, 22, 23, 24}, 
                     {25, 26, 27, 28}, 
                     {29, 30, 31, 32}};
        int n = 4;
        int[][] c = new int[n][n];
        matrixmul(a, b, n, c);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}