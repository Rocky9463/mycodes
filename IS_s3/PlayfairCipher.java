import java.util.LinkedHashSet;
public class PlayfairCipher {
    private static String alphabets = "abcdefghiklmnopqrstuvwxyz";
    private static String cipherText="";
    static LinkedHashSet<Character> finalKey = new LinkedHashSet<>();
    public static String standardFunction(String text) {
        String lowerCaseText = text.toLowerCase();
        String cleanedText = lowerCaseText.replaceAll("\\W", "");
        return cleanedText;
    }

    public static String generatekey(String key) {
        key = standardFunction(key).replaceAll("j", "i");
        String fk = key + alphabets;
        for (char c : fk.toCharArray()) {
            finalKey.add(c);
        }
        String finalkeyString="";
        for (Character element : finalKey) {
            finalkeyString+=element;
        }
        return finalkeyString;
    }

    public static String cleanPlainText(String p){
        String cleanedText="";
        String plainText = standardFunction(p);
        
        int i=0;
        while(i < plainText.length()-1){
            cleanedText += plainText.charAt((i));
            if (plainText.charAt(i)==plainText.charAt(i+1)){
                cleanedText += "x";
                i+=1;
            }else{
                cleanedText += plainText.charAt((i+1));
                i+=2;
            }
        }
        if (cleanedText.charAt(cleanedText.length()-1) != plainText.charAt((plainText.length()-1))){
            cleanedText += plainText.charAt((plainText.length()-1));
        }


        if (cleanedText.length()%2!=0){
            cleanedText+="x";
        }
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
    
    public static String encrypt(String plainText, String key){
        char[] p = cleanPlainText(plainText).toCharArray();
        String finalKey = generatekey(key);
        int r1, c1, r2, c2;
        for(int i=0; i<p.length-1; i+=2){
            c1  = finalKey.indexOf(p[i]);
            c2  = finalKey.indexOf(p[i+1]);
            r1 = c1/5; c1 = c1%5; r2=c2/5; c2=c2%5;
            if(r1==r2){
                cipherText+=finalKey.charAt(5*r1 + calculateModulus(c1+1, 5));
                cipherText+=finalKey.charAt(5*r1 + calculateModulus(c2+1, 5));
            }else if(c1==c2){
                cipherText+=finalKey.charAt(5*calculateModulus(r1+1, 5)+c1);
                cipherText+=finalKey.charAt(5*calculateModulus(r2+1, 5)+c2);
            }else{
                cipherText+=finalKey.charAt(5*r1+c2);
                cipherText+=finalKey.charAt(5*r2+c1);
            }
        }        
        return cipherText;
    }
    public static void main(String s[]){
        // System.out.println(generatekey("Deepanshu"));
        // System.out.println(cleanPlainText("Hello meet us at ich"));
        System.out.println(encrypt("Hello meet us at ich", "deepanshu"));
    }
}


/*import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class PlayfairCipher {
    public static void main(String s[]){
        Character[][] matrix = new Character[5][5];
        String key = "DEEPANSHU";
        key = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder inserted = new StringBuilder();
        LinkedHashSet<Character> lhSet = new LinkedHashSet<>();
        for (char c : key.toCharArray()) {
            lhSet.add(c);
        }
        List<Character> numberList = new ArrayList<>(lhSet);
        int index = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                Character elementAtIndex = numberList.get(index);
                matrix[i][j] = elementAtIndex;
                index++;
            }
        }
        String msg = "hello us meet at ich";
        msg = msg.replaceAll("\\s", "");
        char[] ms = msg.toCharArray();
        int i=0;
        int j = 1;
        while(j<ms.length){
            j=i+1;
            if(ms[i]==ms[j]){
                System.out.println(ms[i]);
                i++;
            }
            i++;
            j++;
        }
        System.out.println(ms);




        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
  }
}

*/