import java.util.*;

public class PriorityQueueHeap {

    static void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[largest])
            largest = left;

        if (right < n && a[right] > a[largest])
            largest = right;

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }
    }

    static void buildHeap(int a[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
    }

    static int deleteMax(int a[], int n) {
        int max = a[0];

        a[0] = a[n - 1];
        heapify(a, n - 1, 0);

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size :");
        int n = sc.nextInt();

        Random r = new Random();
        int a[] = new int[n];

        System.out.println("Passenger Priorities :");

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100);
            System.out.print(a[i] + " ");
        }

        long start = System.nanoTime();

        buildHeap(a, n);

        long end = System.nanoTime();

        double time = (end - start) / 1e6;

        System.out.println("\n\nBoarding Order (Highest Priority First):");

        int size = n;
        while (size > 0) {
            System.out.print(deleteMax(a, size) + " ");
            size--;
        }

        System.out.println("\nTime taken : " + time + " ms");

        sc.close();
    }
}