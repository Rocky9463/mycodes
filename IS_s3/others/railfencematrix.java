public class railfencematrix {
    public static char[][] transposeMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] transposedMatrix = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void encr(char[][]matrix, int[]key){
        matrix = transposeMatrix(matrix);
        int row = matrix.length;
        int col = matrix[0].length;
        char[][] temp = new char[row][col];
        for(int i=0; i<key.length; i++){
            temp[i] = matrix[key[i]-1];
        }
        temp = transposeMatrix(temp);
        printMatrix(temp);
    }
    public static void main(String s[]){
        char[][] matrix = {{'a','b','c','d','e','f'},{'g','h','i','j','k','l'},{'m','n','o'}};
        // char[][] matrix = {{'b','e','c','f','a','d'},{'h','k','i','l','g','j'}};
        int[] key = {2,5,3,6,1,4};
        // int[] key = {5,1,3,6,2,4};
        encr(matrix, key);
        

    }
}