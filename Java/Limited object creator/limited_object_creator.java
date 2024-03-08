// WAP to count total number of objects created for that class without using for loop or any other iterative statement and restrict object creation if any threshhold value is reached.
// METHOD 2
import java.util.*;
public class limited_object_creator {
    private static int objectCount =  0;
    private static final int THRESHOLD =  5;
    public limited_object_creator() {
        if (objectCount < THRESHOLD) {
            objectCount++;
        }else{
            System.out.println("No more objects can be created");
            System.out.println("Total number of objects created: " + limited_object_creator.getObjectCount());
            System.exit(0);
        }
    }
    public static int getObjectCount() {
        return objectCount;
    }
    public static void main(String[] args) {
        limited_object_creator obj1 = new limited_object_creator();
        limited_object_creator obj2 = new limited_object_creator();
        limited_object_creator obj3 = new limited_object_creator();
        limited_object_creator obj4 = new limited_object_creator();
        limited_object_creator obj5 = new limited_object_creator();
        limited_object_creator obj6 = new limited_object_creator();
        limited_object_creator obj7 = new limited_object_creator();
        
    }
}
