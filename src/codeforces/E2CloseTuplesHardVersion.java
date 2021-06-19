package codeforces;

import tool.Com;
import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;
import java.util.Arrays;

public class E2CloseTuplesHardVersion {
    long MOD = (long)1e9 + 7;
    long[][] c = new long[200002][102];
    Com com = new Com(MOD);
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        c();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
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
                ans = (ans + c[index-i-1][m-1])%MOD;
            }
            out.println(ans);

        }
    }
    void c() {
        for (int i = 0; i < 200001; i++) {
            c[i][0] = 1;
        }
        for (int i = 1; i < 200001; i++) {
            for (int j = 1; j < 101; j++) {
                c[i][j] = (c[i-1][j-1] + c[i-1][j])%MOD;
            }
        }

    }
}
