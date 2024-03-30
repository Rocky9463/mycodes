import java.util.*;
public class CustomMethods{
    public static void rpad(String s,char c, int len){
        StringBuilder builder = new StringBuilder(s);
        if (s.length() < len){
            //String newString = "a".repeat(len);
            for(int i=0; i< (len-s.length()); i++){
                builder.append(c);
            }
        }
        System.out.println(builder);
    }
    public static void main(String s[]){
        rpad("hello", '$', 9);
    }
}