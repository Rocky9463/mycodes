import java.util.*;
import static java.lang.System.*;
class Container{
    private String itemName;
    private int profit;
    private int weight
    Container(String itemName, int profit, int weight){
        this.itemName = itemName;
        this.profit = profit;
        this.weight = weight;
    }
    public String getItemName(){
        return this.itemName;
    }
    public String getProfit(){
        return this.profit;
    }
    public String getWeight(){
        return this.weight;
    }
}

class knapsack{
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        out.print("How many items are there? : ");
        int numOfItems = sc.nextInt();
        Container[] item = new Container[numOfItems];
        out.print("What's the capacity of container? : ");
        int capacity = sc.nextInt();
        for(int i=0; i<numOfItems; i++){
            out.print("Enter name, profit, weight of item"+i+1+" (respectively) : ");
            String itemName = sc.next();
            int profit = sc.nextInt();
            int weight = sc.nextInt();
            item[i] = new Container(itemName, profit, weight);
        }
        
    }
}