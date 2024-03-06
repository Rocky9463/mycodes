// WAP to accept n numbers from commnd line and display sum of cube each number.

import java.util.*;
class sumofcube{
    public static void main(String s[]){
        int sum = 0;
        for(int i=0; i<s.length; i++){
            int temp = Integer.parseInt(s[i]);
            sum = sum + temp*temp*temp;
        }
        System.out.println(sum);
    }
}