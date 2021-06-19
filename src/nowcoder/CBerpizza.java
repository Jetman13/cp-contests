package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class CBerpizza {
    class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int q = in.nextInt();
        Queue<Node> qu = new PriorityQueue<>((a,b)->{
            if (a.val == b.val) {
                return a.index - b.index;
            }
            return b.val - a.val;
        });
        int[] tmp = new int[q+1];
        int ind = 1;
        int start = 1;
        for (int i = 1; i <= q; i++) {
            int k = in.nextInt();
            if (k == 1) {
                int m = in.nextInt();
                tmp[ind] = m;
                qu.offer(new Node(ind++,m));

            } else if (k == 2) {
                while (tmp[start] <= 0) start++;
                out.println(start);
                tmp[start++] = -1;

            } else {
                while (!qu.isEmpty() && tmp[qu.peek().index] <= 0) qu.poll();
                out.println(qu.peek().index);
                tmp[qu.peek().index] = -1;
                qu.poll();

            }
        }
    }
}
