import java.util.*;

public class Main {

    static void quickSort(int[] ar, int lo, int hi) {
        if (lo >= hi) return;          // mảng con độ dài <= 1 thì coi như đã sắp xếp, không in

        int p = partition(ar, lo, hi); // vị trí cuối cùng của pivot
        printArray(ar);                // in cả mảng sau mỗi lần partition

        quickSort(ar, lo, p - 1);      // nửa trái trước
        quickSort(ar, p + 1, hi);      // rồi mới đến nửa phải
    }

    static int partition(int[] ar, int lo, int hi) {
        int pivot = ar[hi]; // pivot là phần tử cuối
        int i = lo;         // i: vị trí tiếp theo dành cho phần tử nhỏ hơn pivot

        for (int j = lo; j < hi; j++) {
            if (ar[j] < pivot) {
                swap(ar, i, j);
                i++;
            }
        }
        swap(ar, i, hi);    // đưa pivot về đúng chỗ
        return i;
    }

    static void swap(int[] ar, int a, int b) {
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }

    static void printArray(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ar.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ar[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();

        quickSort(ar, 0, n - 1);
    }
}