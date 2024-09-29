class Hill{
    String key;
    String p;
    static String alpha = "abcdefghijklmnopqrstuvwxyz";
    
    Hill(String key, String p){
        this.key = key;
        this.p=p;
        this.p = standardFunction(p);
        String k = addExtraX(key);
        int[][] mat = strtoMat(k);
        for(int[] i : mat){
            for(int j : i){
            System.out.print(j+"  ");
            }
            System.out.println();
        }
        double det = determinant(mat);
        System.out.println(calculateModulus((int) det,26));

    }
    
    public static String standardFunction(String text) {
        String lowerCaseText = text.toLowerCase();
        String cleanedText = lowerCaseText.replaceAll("\\W", "");
        return cleanedText;
    }
    public static int calculateModulus(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        if(dividend<0){
            if (divisor < 0){
                return (Math.abs(dividend) % Math.abs(divisor)) * -1;
            }
            if(Math.abs(dividend)<Math.abs(divisor)){
                return (Math.abs(divisor)-Math.abs(dividend));
            }else{
                int m1 = Math.abs(dividend)%Math.abs(divisor);
                return calculateModulus(-m1,divisor);
            }
        }
        return Math.abs(dividend % divisor);
    }
    public static String addExtraX(String txt){
        double sqrt=Math.sqrt(txt.length());
        if((sqrt - Math.floor(sqrt)) != 0){
            sqrt = Math.ceil(sqrt);
            for(int i=txt.length(); i<sqrt*sqrt; i++){
                txt = txt + "x";
            }
        }
        return txt;
    }
    public static int[][] strtoMat(String txt){
        double sqrt=Math.sqrt(txt.length());
        int[][] mat = new int[(int)sqrt][(int)sqrt];
        int k=0; 
        for(int i=0; i<sqrt; i++){
            for(int j=0; j<sqrt; j++){
                mat[i][j] = alpha.indexOf(txt.charAt(k++));
            }
        }
        return mat;
    }

    public static double determinant(int[][] matrix) {
        int n = matrix.length;
        
        if (n == 1) {
            return matrix[0][0];
        }
        
        if (n == 2) {
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        
        double det = 0;
        for (int i = 0; i < n; i++) {
            int[][] subMatrix = getSubMatrix(matrix, 0, i);
            det += Math.pow(-1, i) * matrix[0][i] * determinant(subMatrix);
        }
        
        return det;
    }
    private static int[][] getSubMatrix(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] subMatrix = new int[n-1][n-1];
        int r = 0, c = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                subMatrix[r][c++] = matrix[i][j];
                if (c >= n-1) {
                    r++;
                    c = 0;
                }
            }
        }
        return subMatrix;
    }

    public static void main(String s[]){
        String p1 = "hello";
        String key = "rohit";
        Hill hill = new Hill(key, p1);


        
    }
}