import java.util.*;
public class Caesar_Cipher {
    public String plaintext;
    private String ciphertext;

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
            if(Math.abs(dividend)<Math.abs(divisor)){
                if(divisor<0){
                    return (Math.abs(divisor)-Math.abs(dividend))*-1;
                }
                return (Math.abs(divisor)-Math.abs(dividend));
            }else{
                int m1 = Math.abs(dividend)%Math.abs(divisor);
                return calculateModulus(-m1,divisor);
            }
        }
        return Math.abs(dividend % divisor);
    }
    public static String encypt(String text, int key){
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int ascii = (int) c + key;
            ascii = base + calculateModulus((ascii - base), 26);
            encrypted.append((char) ascii);
        }
        return encrypted.toString();
    }
    public static String decrypt(String input, int key) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int ascii = (int) c - key;
            ascii = base + calculateModulus((ascii - base + 26), 26);
            decrypted.append((char) ascii);
        }
        return decrypted.toString();
    }
    
    public static void main(String s[]){
        Caesar_Cipher obj = new Caesar_Cipher();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n\n+++++  MENU  +++++++");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.println("3. Exit");
            System.out.print("\nEnter choice : ");
            int choice = sc.nextInt(); // Read the choice
            sc.nextLine(); // Consume the leftover newline
    
            switch (choice){
                case 1:
                    System.out.print("Enter plain text : ");
                    obj.plaintext = sc.nextLine(); // Now this reads the actual input
                    obj.plaintext = standardFunction(obj.plaintext);
                    obj.ciphertext = encypt(obj.plaintext, 3);
                    System.out.println(obj.ciphertext);
                    break;
                case 2:
                    System.out.print("Enter cipher text : ");
                    obj.ciphertext = sc.nextLine(); // Similarly, read the actual input
                    obj.plaintext = decrypt(obj.ciphertext, 3);
                    System.out.println(obj.plaintext); 
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("\n\nInvalid input!!!\nTry again.");
                    break;
            } 
    
        }while(true);
    }
}
