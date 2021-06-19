package codeforces;

import tool.FastReader;
import tool.FenwichTree;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BNapoleonCake {
    class Node {
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n+2];


            List<Node> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int k = in.nextInt();
                k = k > i ? i : k;
                int l = i-k+1;
                int r = i;
                a[l]++;
                a[r+1]--;
                list.add(new Node(l,r));
            }



            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum+=a[i];
                out.print(sum > 0 ? 1 : 0);
                out.print(" ");
            }
            out.println();

        }
    }
}
