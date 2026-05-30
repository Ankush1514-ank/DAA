import java.util.*;

public class CountingSort {

    static void countingSort(int a[], int n) {
        int count[] = new int[101]; // Marks range 0-100

        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }

        int index = 0;

        for (int i = 0; i <= 100; i++) {
            while (count[i] > 0) {
                a[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size :");
        int n = sc.nextInt();

        Random r = new Random();
        int a[] = new int[n];

        System.out.println("Marks in the array :");

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(101); // 0 to 100
            System.out.print(a[i] + " ");
        }

        long start = System.nanoTime();
        countingSort(a, n);
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