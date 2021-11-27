package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DPlayTrain {
    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        Node[] index = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            index[i] = new Node(i,null,null);
        }
        while (q-- > 0) {
            int p = in.nextInt();
            if (p == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                index[l].next = index[r];
                index[r].pre = index[l];
            } else if (p == 2) {
                int l = in.nextInt();
                int r = in.nextInt();
                index[l].next = null;
                index[r].pre = null;
            } else {
                List<Integer> ans = new ArrayList<>();
                int k = in.nextInt();
                Node start = index[k];
                while (start.pre != null) {
                    start = start.pre;
                }
                while (start != null) {
                    ans.add(start.val);
                    start = start.next;
                }
                out.println(ans.size());
                for (int i = 0; i < ans.size(); i++) {
                    out.print(ans.get(i) + " ");
                }
                out.println();
            }
        }
    }
}
