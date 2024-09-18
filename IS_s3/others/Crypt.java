public class Crypt{
    public static ceaser_encypt(String text, int key){
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int ascii = (int) c + key;
            ascii = base + (ascii - base) % 26;
            encrypted.append((char) ascii);
        }
        return encrypted.toString();
    }


    public static void main(String s[]){
        System.out.println()
    }
}