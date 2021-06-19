package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CLongJumps {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            in.readArr(a);

            long[] dp = new long[n+2];

            dp[n] = a[n-1];
            long ans = dp[n];
            for (int i = n-1; i >0 ; i--) {
                if (a[i-1] > n-i) {
                    dp[i] = a[i-1];
                    continue;
                }
                dp[i] = dp[i+a[i-1]] + a[i-1];
            }

            out.println(Arrays.stream(dp).max().getAsLong());

        }
    }
}
