import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class PlayfairCipher {
    public static void main(String s[]){
        Character[][] matrix = new Character[5][5];
        String key = "DEEPANSHU";
        key = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder inserted = new StringBuilder();
        LinkedHashSet<Character> lhSet = new LinkedHashSet<>();
        for (char c : key.toCharArray()) {
            lhSet.add(c);
        }
        List<Character> numberList = new ArrayList<>(lhSet);
        int index = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                Character elementAtIndex = numberList.get(index);
                matrix[i][j] = elementAtIndex;
                index++;
            }
        }
        String msg = "hello us meet at ich";
        msg = msg.replaceAll("\\s", "");
        char[] ms = msg.toCharArray();
        int i=0;
        int j = 1;
        while(j<ms.length){
            j=i+1;
            if(ms[i]==ms[j]){
                System.out.println(ms[i]);
                i++;
            }
            i++;
            j++;
        }
        System.out.println(ms);




        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
  }
}

