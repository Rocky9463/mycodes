public class gcd{
    public static int res;
    gcd(int p,int q){
        gcd.res = calmod(p,q);
        display();
    }
    public static int calmod(int p, int q){
        if (q == 0){
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        if(p<0){
            if (q<0){
                return (calmod(Math.abs(p),Math.abs(q))) * -1;
            }
            if(Math.abs(p)<Math.abs(q)){
                return (Math.abs(q)-Math.abs(p));
            }else{
                int m1 = Math.abs(p)%Math.abs(q);
                return calmod(-m1,q);
            }
        }
        return Math.abs(p % q);
    }
    public void display(){
        System.out.println(gcd.res);
    }
    public static void main(String s[]){
        new gcd(-3, 5);
    }
}