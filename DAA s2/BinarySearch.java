import java.util.*;
public class BinarySearch {
    public static int binsearch(int[] a, int i, int l, int x) {
        if (l < i) {
            return -1; 
        }
        int mid = (i + l) / 2;
        if (x == a[mid]) {
            return mid;
        } else if (x < a[mid]) {
            return binsearch(a, i, mid - 1, x);
        } else {
            return binsearch(a, mid + 1, l, x);
        }
    }

    public static void main(String s[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to search: ");
        int x = sc.nextInt();
        int pos = binsearch(a, 0, a.length - 1, x);
        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at position: " + pos);
        }
    }
}
