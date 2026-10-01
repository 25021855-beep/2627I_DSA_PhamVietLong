import java.util.Scanner;

public class Main {
    public static int binarySearchFirst(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] < key) {
                left = mid + 1;
            }
            else if (a[mid] > key) {
                right = mid - 1;
            }
            else {
                result = mid;      // đã tìm thấy key
                right = mid - 1;   // tiếp tục tìm bên trái
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        int index = binarySearchFirst(a,key);
        System.out.println(index);

        sc.close();
    }


}