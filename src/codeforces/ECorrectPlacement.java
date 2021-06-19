package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECorrectPlacement {

    class Node {
        int l,r;
        int index;

        public Node(int l, int r,int index) {
            this.l = l;
            this.r = r;
            this.index = index;
        }
    }

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();

            List<Node> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                list.add(new Node(Math.min(a,b),Math.max(a,b),i));
            }

            Collections.sort(list,(a,b)->a.l-b.l);

            int[] ans = new int[n];

            int[] min = new int[n];
            int val = list.get(0).r;
            min[0] = 0;
            for (int i = 1; i < n; i++) {
                min[i] = min[i-1];
                if (list.get(i).r < val) {
                    min[i] = i;
                    val = list.get(i).r;
                }
            }

            ans[list.get(0).index] = -1;
            int r = -1;
            for (int i = 1; i < n; i++) {
                if (list.get(i).l > list.get(i-1).l) {
                    r = i-1;
                }
                if (r < 0) {
                    ans[list.get(i).index] = -1;
                    continue;
                }
                int minIndex = min[r];
                if (minIndex == i) {
                    ans[list.get(i).index] = -1;
                    continue;
                }
                if (list.get(i).l > list.get(minIndex).l && list.get(i).r > list.get(minIndex).r) {
                    ans[list.get(i).index] = list.get(minIndex).index+1;
                } else {
                    ans[list.get(i).index] = -1;
                }
            }

            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();

        }
    }
}
