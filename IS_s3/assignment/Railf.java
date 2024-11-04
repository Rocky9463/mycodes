import java.util.Scanner;
public class Railf {
    private static String p;
    private static String c;
    Scanner sc = new Scanner(System.in);
    Railf(){
        encrypt();
        decrypt();
    }
    public void encrypt(){
        System.out.print("Enter plain text : ");
        p = sc.nextLine();
        p = stdfunc.standardize(p);
        int l = p.length();
        if (l%2!=0){
            p = p+"x";
        }
        l = p.length();
        c="";
        String s1="";
        String s2="";
        for (int i=0;i<l;i+=2){
            s1 += p.charAt(i);
            s2 += p.charAt(i+1);
        }
        c=s1+s2;
        display(c);
    }
    public void decrypt(){
        c="";
        System.out.print("Enter cipher text : ");
        c = sc.nextLine();
        int l = c.length();
        p="";
        for (int i=0;i<l/2;i++){
            p += c.charAt(i);
            p += c.charAt((l/2)+i);
        }
        display(p);
    }
    public void display(String s){
        System.out.println(s);
    }
    public static void main(String s[]){
        new Railf();
    }
}
