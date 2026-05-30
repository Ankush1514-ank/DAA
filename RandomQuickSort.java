import java.util.*;

public class RandomQuickSort {

    static Random rand = new Random();

    static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    static int randomPartition(int a[], int low, int high) {
        int random = low + rand.nextInt(high - low + 1);

        int temp = a[random];
        a[random] = a[high];
        a[high] = temp;

        return partition(a, low, high);
    }

    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int p = randomPartition(a, low, high);

            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size :");
        int n = sc.nextInt();

        Random r = new Random();
        int a[] = new int[n];

        System.out.println("Elements in the array :");

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(1000);
            System.out.print(a[i] + " ");
        }

        long start = System.nanoTime();
        quickSort(a, 0, n - 1);
        long end = System.nanoTime();

        double time = (end - start) / 1e6;

        System.out.println("\nSorted List :");
        for (int i : a) {
            System.out.print(i + " ");
        }

        System.out.println("\nTime taken : " + time + " ms");

        sc.close();
    }
}