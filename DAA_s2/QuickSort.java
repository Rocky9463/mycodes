import java.util.*;

public class QuickSort {
    public static void quicksort(int[] a, int p, int q) {
        if (p < q) {
            int j = partition(a, p, q);
            quicksort(a, p, j - 1);
            quicksort(a, j + 1, q);
        }
    }

    public static int partition(int[] a, int p, int q) {
        int pivot = a[q];
        int i = p - 1;
        for (int j = p; j < q; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[q];
        a[q] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = {8, 7, 2, 1, 0, 9, 6};
        int[] a = {2, 9, 9, 7, 9, 2, 4, 5, 8};
        System.out.println("Unsorted Array:");
        System.out.println(Arrays.toString(a));

        int size = a.length;
        quicksort(a, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(a));
    }
}