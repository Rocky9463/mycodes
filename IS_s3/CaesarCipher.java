public class CaesarCipher {
    private static String alphabets = "abcdefghijklmnopqrstuvwxyz";
    private static String plainText="", cipherText="";
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
    public static String standardFunction(String text) {
        String lowerCaseText = text.toLowerCase();
        String cleanedText = lowerCaseText.replaceAll("\\W", "");
        return cleanedText;
    } 
    public static String encrypt(String inputText, int key){
        int pos;
        plainText = standardFunction(inputText);
        for(int i=0; i<plainText.length(); i++){
            pos = alphabets.indexOf(plainText.charAt(i));
            char ch = alphabets.charAt(calculateModulus(pos + key,26));
            cipherText = cipherText+ch;
        }
        return cipherText;
    }
    public static String decrypt(String inputText, int key){
        int pos;
        plainText = inputText;
        for(int i=0; i<plainText.length(); i++){
            pos = alphabets.indexOf(plainText.charAt(i));
            char ch = alphabets.charAt(calculateModulus(pos - key,26));
            cipherText = cipherText+ch;
        }
        return cipherText;
    }
    // CaesarCipher(String )
    public static void main(String s[]){
        // CaesarCipher obj = new CaesarCipher();
        // alphabets = alphabets+"hello";
        System.out.println(encrypt("HeL Lo",3));
    }
}
