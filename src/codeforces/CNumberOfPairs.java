package codeforces;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class CNumberOfPairs {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long lval = in.nextLong();
            long rval = in.nextLong();
            long[] a = new long[n];
            in.readArr(a);

            RuffleSort.ruffleSort(a);

            int ans = 0;

            int l = -1;
            int r = -1;
            for (int i = 1; i < n; i++) {
            }

        }
    }
}
