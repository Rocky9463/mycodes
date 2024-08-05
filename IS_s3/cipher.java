public class cipher{
    public static String ceaser_encypt(String text, int key){
        text = text.toUpperCase();
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            int ascii = (int) c + key;
            ascii = 65 + (ascii - 65) % 26;
            key = (int) c - 65;
            encrypted.append((char) ascii);
        }
        return encrypted.toString();
    }


    public static void main(String s[]){
        System.out.println(ceaser_encypt("hello",24));
    }
}