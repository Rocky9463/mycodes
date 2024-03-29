import java.util.*;

public class MergeSort {
    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (int) Math.floor((low + high) / 2);
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[mid + 1 + j];

        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String s[]) {
        int[] a = {2, 9, 9, 7, 9, 2, 4, 5, 8};
        int high = a.length - 1;
        System.out.println("Before sorting: " + Arrays.toString(a));
        mergesort(a, 0, high);
        System.out.println("After sorting: " + Arrays.toString(a));
    }
}
