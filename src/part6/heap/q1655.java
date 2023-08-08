package part6.heap;

import java.io.*;
import java.util.*;


public class q1655 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxPQ.size() == minPQ.size()) maxPQ.offer(num);
            else minPQ.offer(num);

            if (!maxPQ.isEmpty() && !minPQ.isEmpty())
                if (maxPQ.peek() > minPQ.peek()) {
                    int tmp = minPQ.poll();
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(tmp);
                }
                sb.append(maxPQ.peek() + "\n");
        }
        System.out.println(sb);
    }
}
