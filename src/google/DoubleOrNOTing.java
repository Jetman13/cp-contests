package google;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class DoubleOrNOTing {
    class Node {
        long val;
        int p;

        public Node(long val, int p) {
            this.val = val;
            this.p = p;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String sstr = in.next();
        String estr = in.next();
        long s = Long.valueOf(sstr,2);
        long e = Long.valueOf(estr,2);
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s,0));
        int ans = -1;
        boolean[] f = new boolean[1000001];
        f[(int)s] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.val == e) {
                ans = node.p;
                break;
            }
            if ((node.val<<1) < 1000001 && !f[(int)(node.val<<1)]) {
                q.offer(new Node(node.val << 1, node.p + 1));
                f[(int)(node.val<<1)] = true;
            }
            long fan = fan(node.val);
            if ((fan) < 1000001 && !f[(int)(fan)]) {
                q.offer(new Node(fan, node.p + 1));
                f[(int)(fan)] = true;
            }
        }
        out.println("Case #" + testNumber + ": " + ((ans == -1) ? "IMPOSSIBLE" : ans));
    }

    private long fan(long val) {
        char[] chs = Long.toBinaryString(val).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            chs[i] = chs[i] == '1' ? '0' : '1';
        }
        return Long.valueOf(String.valueOf(chs),2);
    }
}
