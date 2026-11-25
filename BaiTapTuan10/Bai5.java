package BaiTapTuan10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai5 {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        int[] count = new int[10001];
        for(int num: brr) {
            count[num]++;
        }
        for(int num:arr) {
            count[num]--;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 10000; i++) {
            if(count[i] > 0) {
                result.add(i);
            } 
        }
        return result;
    } 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> brr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            brr.add(scanner.nextInt());
        }
        List<Integer> result = missingNumbers(arr, brr);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}
