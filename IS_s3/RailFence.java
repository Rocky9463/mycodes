import java.util.Arrays;

public class RailFence {
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

    public static char[][] createMatrix(String p, int col){
        int row = p.length()/col;
        if(p.length()%col!=0){
            row+=1;
        }
        for(int i=p.length(); i<row*col; i++){
            p=p+"x";
        }
        char[][] matrix = new char[row][col];
        char[] ch = p.toCharArray();
        int k=0; 
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                matrix[i][j] = ch[k++];
            }
        }
        return matrix;
    }

    public static void encr(String p, int[]key, int col){
        char[][] matrix = createMatrix(p, col);
        int row = matrix.length;
        col = matrix[0].length;
        char[][] temp = new char[row][col];
        // for (char[] r : temp) 
        //     Arrays.fill(r, '0'); 
        temp = transposeMatrix(temp);
        matrix = transposeMatrix(matrix);

        for(int i=0; i<key.length; i++){
            temp[i] = matrix[key[i]-1];
        }
        
        temp = transposeMatrix(temp);
        printMatrix(temp);

        
    }

    public static void main(String s[]){
        int[] key = {2,5,3,6,1,4};
        String p = "Hellomeetusatich";
        String c = "eolmHlestaeuixcxth";
        int[] kc = {5,1,3,6,2,4};
        encr(p, key, key.length);  
        System.out.println();   
        encr(c, kc, kc.length);    
    }    
}