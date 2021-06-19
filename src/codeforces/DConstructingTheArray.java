package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class DConstructingTheArray {
    class Node {
        int l,r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
        public int getNum() {
            return this.r - this.l;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            int[] a = new int[n];


            Queue<Node> q = new PriorityQueue<>((aa,bb) -> {
                return aa.getNum() == bb.getNum() ? (aa.l - bb.l) : (bb.getNum() - aa.getNum());
            });

            q.add(new Node(0,n-1));
            int num = 1;
            while (!q.isEmpty()) {
                Node node = q.poll();
                int index = (node.r+node.l)/2;
                a[index] = num++;
                if (node.l <= index-1) {
                    q.add(new Node(node.l, index - 1));
                }
                if (index+1 <= node.r) {
                    q.add(new Node(index + 1, node.r));
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(a[i] + " ");
            }
            out.println();



        }
    }
}
