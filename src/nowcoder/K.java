package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class K {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        Queue<Integer> q = new PriorityQueue<>((a,b)->b-a);

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (q.size() < k || q.peek() > tmp) {
                q.offer(tmp);
            }
            if (q.size() > k) {
                q.poll();
            }
        }

        for (int i = 0; i < m; i++) {
            int op = in.nextInt();
            if (op == 1) {
                int tmp = in.nextInt();
                if (q.size() >= k && q.peek() <= tmp) continue;
                q.offer(tmp);
                if (q.size() > k) {
                    q.poll();
                }
            } else {
                if (q.size() < k) {
                    out.println(-1);
                } else {
                    out.println(q.peek());
                }
            }
        }

    }
}
