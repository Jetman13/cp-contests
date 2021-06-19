package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.*;

public class CPhoenixAndTowers {
    class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            Queue<Node> ts = new PriorityQueue<>((aa,bb)->aa.val-bb.val);
            int[] ans = new int[n];
            for (int i = 0; i < m; i++) {
                ts.add(new Node(a[i],i+1));
                ans[i] = i+1;
            }

            for (int i = m; i < n; i++) {
                Node node = ts.poll();
                ans[i] = node.index;
                node.val+=a[i];
                ts.add(node);
            }

            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();

        }
    }

}
