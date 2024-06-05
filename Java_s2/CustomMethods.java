import java.util.*;
public class CustomMethods{
    public static String rpad(String s,char c, int len){
        StringBuilder builder = new StringBuilder(s);
        if (s.length() < len){
            for(int i=0; i< (len-s.length()); i++){
                builder.append(c);
            }
        }
        String output = new String(builder);
        return(output);
    }

    public static String lpad(String s,char c, int len){
        StringBuilder builder = new StringBuilder();
        if (s.length() < len){
            for(int i=0; i< (len-s.length()); i++){
                builder.append(c);
            }
        }
        String output = builder+s;
        return(output);
    }

    public static String ltrim(String s){
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return s.substring(i);
    }

    public static String rtrim(String s){
        int i = s.length() - 1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0, i + 1);
    }

    public static int count(String input, char character) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    public static String encrypt(String input, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int ascii = (int) c + shift;
            ascii = base + (ascii - base) % 26;
            encrypted.append((char) ascii);
        }
        return encrypted.toString();
    }

    public static String decrypt(String input, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int ascii = (int) c - shift;
            ascii = base + (ascii - base + 26) % 26;
            decrypted.append((char) ascii);
        }
        return decrypted.toString();
    }

    public static void main(String s[]){
        String res;
        res = rpad("hello", '$', 9);
        System.out.println("Rpad : "+ res);

        res = lpad("hello", '$', 9);
        System.out.println("lpad : "+ res);

        res = ltrim("    hello     ");
        System.out.println("ltrim : "+ res);

        res = rtrim("    hello     ");
        System.out.println("rtrim : "+ res);
                
        int count_value = count("hello", 'l');
        System.out.println(count_value);

        res = encrypt("Java", 5);
        System.out.println(res);

        res = decrypt("Ofaf", 5);
        System.out.println(res);

        
    }
}