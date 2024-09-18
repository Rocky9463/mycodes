public class VernamCipher {
    
    public static String encrypt(String binaryPlaintext, String binaryKey) {
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = binaryKey.length();
        
        for (int i = 0; i < binaryPlaintext.length(); i++) {
            char plaintextBit = binaryPlaintext.charAt(i);
            char keyBit = binaryKey.charAt(i % keyLength);
            
            char encryptedBit = (char) (((plaintextBit - '0') ^ (keyBit - '0')) + '0');
            ciphertext.append(encryptedBit);
        }
        return ciphertext.toString();
    }

    public static String decrypt(String binaryCiphertext, String binaryKey) {
        // Decryption is the same as encryption in Vernam cipher
        return encrypt(binaryCiphertext, binaryKey);
    }

    public static void main(String[] args) {
        String binaryPlaintext = "1001"; // Example binary plaintext
        String binaryKey = "1100"; // Example binary key

        String encrypted = encrypt(binaryPlaintext, binaryKey);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, binaryKey);
        System.out.println("Decrypted: " + decrypted);
    }
}