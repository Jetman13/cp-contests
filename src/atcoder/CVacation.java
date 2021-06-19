package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CVacation {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] dp = new int[n+1][3];
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = in.nextInt();
        }
        dp[1][0] = a[0][0];
        dp[1][1] = a[0][1];
        dp[1][2] = a[0][2];
        for (int i = 2; i <= n ; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + a[i-1][0],dp[i-1][2] + a[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + a[i-1][1],dp[i-1][2] + a[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1] + a[i-1][2],dp[i-1][0] + a[i-1][2]);
        }
        out.println(Math.max(dp[n][0],Math.max(dp[n][1],dp[n][2])));
    }
}
