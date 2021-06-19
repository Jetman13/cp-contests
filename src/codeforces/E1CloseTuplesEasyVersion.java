package codeforces;

import tool.Com;
import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;

public class E1CloseTuplesEasyVersion {
    long MOD = (long)1e13 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = 3;
            int k = 2;
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            RuffleSort.ruffleSort(a);

            long ans = 0;
            int index = 0;
            for (int i = 0; i < n; i++) {
                long tmp = a[i] + k;
                while (index < n && a[index] - a[i] <= k) index++;
                if (index - i < m) continue;
                ans = (ans + C(index-i-1,m-1));
            }
            out.println(ans);

        }
    }

    private long C(int i, int i1) {
        long ans = 1;
        for (int j = 0; j < i1; j++) {
            ans *= (i-j);
        }
        for (int j = 0; j < i1; j++) {
            ans/=j+1;
        }
        return ans;
    }
}
