import java.util.*;
import static java.lang.System.*;
class FiboWithRec{
    static int fibo(int n){
        if(n<=1){
            return n;
        }else{
            return fibo(n-1)+fibo(n-2);
        }
    }
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        out.print("Enter any number : ");
        int n = sc.nextInt();
        out.println(fibo(n));
    }
}