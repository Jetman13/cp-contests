package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class DQueryingMultiset {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int q = in.nextInt();
        long x = 0;
        Queue<Long> qu = new PriorityQueue<>();
        for (int i = 0; i < q; i++) {
            int op = in.nextInt();
            if (op == 1) {
                long k = in.nextLong();
                qu.add(k - x);
            } else if (op == 2) {
                long k = in.nextLong();
                x+=k;
            } else {
                long ans = qu.poll();
                out.println(ans + x);
            }
        }
    }
}
