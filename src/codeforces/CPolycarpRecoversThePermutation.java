package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class CPolycarpRecoversThePermutation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);
            if (a[0] != n && a[n-1] != n) {
                out.println(-1);
                continue;
            }
            LinkedList<Integer> q = new LinkedList<>();
            int l = 0;
            int r = n-1;
            while (l <= r) {
                if (a[l] > a[r]) {
                    q.addFirst(a[l++]);
                } else {
                    q.addLast(a[r--]);
                }
            }

            while (!q.isEmpty()) {
                out.print(q.pollFirst() + " ");
            }
            out.println();

        }
    }
}
