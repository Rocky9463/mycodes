public class CompSBox {
    public static void compress(String val){
        String row = "";
        String col = "";
        row +=  val.charAt(0);
        row += val.charAt(val.length()-1);
        col +=  val.substring(1, 5);
        System.out.println(row+" :: "+col);
        int r =  Integer.parseInt(row,2);
        int c =  Integer.parseInt(col,2);
        System.out.println("Row: "+r+" Col: "+c);
    }    
    public static void main(String s[]){
        String val = "101111";
        compress(val);
    }
}
