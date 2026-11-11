import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static List<Integer> quickSort(List<Integer> arr) {
        int p = arr.get(0); // pivot là phần tử đầu tiên

        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int x : arr) {
            if (x < p) {
                left.add(x);
            } else if (x > p) {
                right.add(x);
            } else {
                equal.add(x);
            }
        }

        List<Integer> result = new ArrayList<>(left);
        result.addAll(equal);
        result.addAll(right);
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result.quickSort(arr);

        System.out.println(
                result.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );

        bufferedReader.close();
    }
}