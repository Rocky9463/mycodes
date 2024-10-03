import java.util.Scanner;
public class Mat {
    static int[][] a;
    Mat(){
        a = new int[2][2];
    }
    Mat(int n){
        a = new int[n][n];
    }
    Mat(int m, int n){
        a = new int[m][n];
    }
    Mat(int[][] b){
        a = b;
    }
    void readElement(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }
    public int[][] cofactor(int[][] mat, int p, int q) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m - 1][n - 1];
        int r = 0;
        for (int i = 0; i < m; i++) {
            if (i != p) {
                int c = 0;
                for (int j = 0; j < n; j++) {
                    if (j != q) {
                        result[r][c] = mat[i][j];
                        c++;
                    }
                }
                r++;
            }
        }   
        return result;
    }
    public int determinant(int[][] mat) {
        int n = mat.length;
        
        if (n == 1) {
            return mat[0][0];
        } else if (n == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }

        int det = 0;
        for (int i = 0; i < n; i++) {
            int[][] subMatrix = cofactor(mat, 0, i);
            int sign = (i % 2 == 0) ? 1 : -1;
            det += sign * mat[0][i] * determinant(subMatrix);
        }
        return det;
    }

    public int[][] adjoint(int[][] mat){
        int n = mat.length;
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j=0; j<n;j++){
                int[][] subMatrix = cofactor(mat, i, j);
                res[i][j] = determinant(subMatrix);
                if ((i+1+j+1)%2 == 1){
                    res[i][j] = -res[i][j];
                }
            }
        }
        return transposeMatrix(res);
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public double[][] invert(int[][] mat) {
        int n = mat.length;
        double[][] inv = new double[n][n];

        int det = determinant(mat);
        if (det == 0) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null;
        }

        double detDouble = det;
        int[][] adjoint = adjoint(mat);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = adjoint[i][j]/detDouble;
            }
        }

        return inv;
    }



    void display(double[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
    void display(int[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        Mat obj = new Mat(n);
        obj.readElement();
        System.out.println("\nDeterminant : "+obj.determinant(a)); 
        System.out.println("\nAdjoint : ");
        obj.display(obj.adjoint(a));
        System.out.println("\nInverse : ");
        obj.display(obj.invert(a));

        sc.close();
    }
}
