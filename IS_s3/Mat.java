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
    void display(int[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String s[]){
        Mat obj = new Mat(3);
        obj.readElement();
        obj.display(obj.cofactor(a, 0, 0));        
    }
}
