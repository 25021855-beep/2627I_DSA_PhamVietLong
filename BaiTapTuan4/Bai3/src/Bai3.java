
import java.util.Scanner;

public class Bai3 {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
     }
    public static  void InsertSort1(int[] a, int n ) {
        int key = a[n - 1];
        int j = n - 2;
        while ( j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            printArray(a);
            j--;
        }
        a[j + 1] = key;
        printArray(a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        InsertSort1(a, n);

        sc.close();
    }
}