public class multInverse {
    public static int findInv(int n){
        for(int i=2; i<26; i++){
            if ((i*n)%26 == 1){
                return i;
            }      
        }
        return -1;
    }  
    public static void main(String s[]){
        for(int i=1; i<26; i++){
            System.out.println(i+" : "+findInv(i));
        }
    }
}
