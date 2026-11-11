
import java.io.*;
import java.util.*;

class Result {
    public static void printArray(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, key);
            printArray(arr);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Result.insertionSort2(n, arr);

        sc.close();
    }
}
