public class test {
    public static void main(String s[]){
        String msg = "hello us meet at ich";
        msg = msg.replaceAll("\\s", "");
        char[] ms = msg.toCharArray();
        int i=0;
        int j = 1;
        while(j<ms.length){
            if(ms[i]==ms[j]){
                System.out.println(ms[i]);
            }
            i++;
            j++;
        }
        System.out.println(ms);
    }
}
