public class VigenerCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String plaintext, int[] key) {
        StringBuilder ciphertext = new StringBuilder();
        plaintext = plaintext.toUpperCase();
        int keyIndex = 0;

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                int plaintextIndex = ALPHABET.indexOf(c);
                int keyShift = key[keyIndex % key.length];
                int encryptedIndex = (plaintextIndex + keyShift) % 26;
                ciphertext.append(ALPHABET.charAt(encryptedIndex));
                keyIndex++;
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int[] key) {
        StringBuilder plaintext = new StringBuilder();
        ciphertext = ciphertext.toUpperCase();
        int keyIndex = 0;

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                int ciphertextIndex = ALPHABET.indexOf(c);
                int keyShift = key[keyIndex % key.length];
                int decryptedIndex = (ciphertextIndex - keyShift + 26) % 26;
                plaintext.append(ALPHABET.charAt(decryptedIndex));
                keyIndex++;
            } else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int[] key = {19, 4, 2, 17, 4, 19}; // Numeric representation of "SECRET"

        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}