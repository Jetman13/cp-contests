package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class BMAXMin {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((aa,bb) -> bb.compareTo(aa));
        list.add(a[0]);
        q.offer(a[0]);
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i-1]) {
                list.add(a[i]);
                q.offer(a[i]);
            }
        }

        int min = a[0];
        while (q.size() > 1) {
            int max = q.peek();
            if (max == min) {
                break;
            }
            while (q.peek() == max) q.poll();
            q.offer(max-min);
            if (max-min < min) {
                min = max - min;
            }
        }
        out.println(q.peek());
        out.flush();


    }
}
