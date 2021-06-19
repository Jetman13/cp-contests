package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class BEasternExhibition {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                b[i] = in.nextLong();
            }

            out.println(cal(a) * cal(b));

        }
    }

    private long cal(long[] a) {
        RuffleSort.ruffleSort(a);
        int len = a.length;
        int mid = len/2;
        if (len%2==1) return 1;
        return a[mid] - a[mid-1] + 1;
    }
}
