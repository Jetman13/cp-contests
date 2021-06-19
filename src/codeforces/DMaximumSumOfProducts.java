package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class DMaximumSumOfProducts {
    long[][] dp ;
    long[] a;
    long[] b;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();

        dp = new long[n+2][n+2];
        long[] lsum = new long[n+2];
        long[] rsum = new long[n+2];

        a = new long[n];
        b = new long[n];
        in.readArr(a);
        in.readArr(b);

        for (int i = 0; i < n; i++) {
            lsum[i+1] = lsum[i] + a[i]*b[i];
        }
        for (int i = n-1; i >= 0 ; i--) {
            rsum[i+1] = rsum[i+2] + a[i]*b[i];
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = a[i-1]*b[i-1];
        }

        long ans = lsum[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                ans = Math.max(ans,lsum[i-1]+rsum[j+1]+work(i,j));
            }
        }
        out.println(ans);

    }

    private long work(int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        return dp[i][j] = work(i+1,j-1) + a[i-1]*b[j-1] + a[j-1]*b[i-1];
    }
}
