package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class B1BiodiverseSubsequence {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] pow = new long[70];

        pow[0] = 1;
        for (int i = 1; i <= 63 ; i++) {
            pow[i] = pow[i-1]*2;
        }

        int[] num = new int[k+2];
        for (int i = 0; i < n; i++) {
            num[in.nextInt()]++;
        }

        long ans = 1;
        for (int i = 1; i <= k ; i++) {
            ans *= pow[num[i]]-1;
        }
        out.println(ans);

    }
}
