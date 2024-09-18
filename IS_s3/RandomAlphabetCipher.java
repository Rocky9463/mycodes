import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomAlphabetCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<Character, Character> encryptionMap;
    private Map<Character, Character> decryptionMap;

    public RandomAlphabetCipher() {
        generateRandomMapping();
    }

    private void generateRandomMapping() {
        List<Character> shuffledAlphabet = new ArrayList<>();
        for (char c : ALPHABET.toCharArray()) {
            shuffledAlphabet.add(c);
        }
        Collections.shuffle(shuffledAlphabet);

        encryptionMap = new HashMap<>();
        decryptionMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            char original = ALPHABET.charAt(i);
            char mapped = shuffledAlphabet.get(i);
            encryptionMap.put(original, mapped);
            decryptionMap.put(mapped, original);
        }
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                ciphertext.append(encryptionMap.get(c));
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                plaintext.append(decryptionMap.get(c));
            } else {
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }

    public void printMapping() {
        System.out.println("Encryption mapping:");
        for (char c : ALPHABET.toCharArray()) {
            System.out.println(c + " -> " + encryptionMap.get(c));
        }
    }

    public static void main(String[] args) {
        RandomAlphabetCipher cipher = new RandomAlphabetCipher();
        String plaintext = "Hello, World!";

        cipher.printMapping();

        String encrypted = cipher.encrypt(plaintext);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
