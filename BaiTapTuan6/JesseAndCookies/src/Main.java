import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : A) {
            pq.add((long) x);
        }

        int count = 0;
        while (pq.peek() < k) {
            if (pq.size() < 2) {
                return -1;
            }
            long least = pq.poll();
            long second = pq.poll();
            pq.add(least + 2 * second);
            count++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println(Result.cookies(k, A));

        bufferedReader.close();
    }
}