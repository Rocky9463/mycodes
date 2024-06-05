import java.util.*;

class Container implements Comparable<Container>{
    private String itemName;
    private int profit;
    private int weight;

    Container(String itemName, int profit, int weight){
        this.itemName = itemName;
        this.profit = profit;
        this.weight = weight;
    }

    public String getItemName(){
        return this.itemName;
    }

    public int getProfit(){
        return this.profit;
    }

    public int getWeight(){
        return this.weight;
    }

    // Implement compareTo method for sorting
    @Override
    public int compareTo(Container other) {
        double ratioThis = ((double)this.getProfit()) / this.getWeight();
        double ratioOther = ((double)other.getProfit()) / other.getWeight();
        return Double.compare(ratioOther, ratioThis); // Reverse order to sort by descending ratio
    }
}

class knapsack{
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many items are there? : ");
        int numOfItems = sc.nextInt();
        Container[] item = new Container[numOfItems];
        System.out.print("What's the capacity of container? : ");
        int capacity = sc.nextInt();

        for(int i=0; i<numOfItems; i++){
            System.out.print("Enter name, profit, weight of item "+(i+1)+" (respectively) : ");
            String itemName = sc.next();
            int profit = sc.nextInt();
            int weight = sc.nextInt();
            item[i] = new Container(itemName, profit, weight);
        }

        // Sort items based on value per unit weight
        Arrays.sort(item);

        double totalProfit = 0;
        for(Container c : item){
            if(capacity == 0) break; // Break if knapsack is full
            double fraction = Math.min((double)capacity/c.getWeight(), 1);
            System.out.println(c.getItemName()+" : "+fraction);
            totalProfit += c.getProfit() * fraction;
            capacity -= c.getWeight() * fraction;
        }

        System.out.println("Total Profit: " + totalProfit);
    }
}