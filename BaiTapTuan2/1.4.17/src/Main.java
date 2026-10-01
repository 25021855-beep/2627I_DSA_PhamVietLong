import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        double[] a = new double[N];
        for(int i = 0; i < N; i++ ) {
            a[i] = sc.nextDouble();
        }

        double min = a[0];
        double max = a[0];

        for (int j = 0; j < a.length; j++) {
            if (min > a[j]) {
                min = a[j];
            }
            if (max < a[j]) {
                max = a[j];
            }
        }
        System.out.println(max - min);
        sc.close();
    }
}