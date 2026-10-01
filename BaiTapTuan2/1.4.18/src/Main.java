import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        int lo = 1;
        int hi = N - 2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                System.out.println(mid);
                System.out.println(a[mid]);
                return;
            } else if (a[mid - 1] < a[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
    }
}