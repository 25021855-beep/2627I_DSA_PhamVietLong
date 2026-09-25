import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int equalStacks (int[] h1, int[] h2, int[] h3) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        long sum1 = 0, sum2 = 0, sum3 = 0;


        for (int i = h1.length -1; i >= 0; i-- ) {
            s1.push(h1[i]);
            sum1 += 1;
        }
        for (int i = h2.length -1; i >= 0; i-- ) {
            s2.push(h2[i]);
            sum2 += 1;
        }
        for (int i = h3.length -1; i >= 0; i-- ) {
            s3.push(h3[i]);
            sum3 += 1;
        }

        while ( sum1 == sum2 && sum2 == sum3) {
            if ( sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.pop();
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.pop();
            } else {
                sum3 -= s3.pop();
            }
        }
        return (int) sum1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); int n2 = sc.nextInt(); int n3 = sc.nextInt();

        int[] h1 = new int[n1];
        for (int i = 0; i < n1; i++) h1[i] = sc.nextInt();

        int[] h2 = new int[n2];
        for (int i = 0; i < n2; i++) h2[i] = sc.nextInt();

        int[] h3 = new int[n3];
        for (int i = 0; i < n3; i++) h3[i] = sc.nextInt();

        System.out.println(equalStacks(h1,h2,h3));
        sc.close();
    }

}