// WAP to find minumum and maximum of given n numbers without using any explicit array.
// Note : Input values using command line
import java.util.*;
public class min_max{
    public static void main(String s[]){
        int max = Integer.parseInt(s[0]);
        int min = Integer.parseInt(s[0]);
        for (int i=1; i<s.length; i++){
            int value = Integer.parseInt(s[i]);
            if (value > max){
                max = value;
            }else if (value < min){
                min = value;
            }
        }
        System.out.println("Minimum : "+ min +"\nMaximum : " + max);
    }
}