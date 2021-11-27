package atcoder;

import tool.FastReader;
import tool.RuffleSort;

import java.io.PrintWriter;

public class CNotEqual {
    long MOD = (long)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] c = new long[n];

        in.readArr(c);

        RuffleSort.ruffleSort(c);

        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = (ans*(c[i]-i))%MOD;
        }
        out.println(ans);

    }
}
