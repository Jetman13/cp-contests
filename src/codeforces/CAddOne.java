package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CAddOne {
    long MOD = (long)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long[][] dp = new long[200022][12];
        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length-1; i++) {
            for (int j = 0; j < 9; j++) {
                dp[i][j] = dp[i-1][j+1];
            }
            dp[i][9] = (dp[i-1][0] + dp[i-1][1])%MOD;
        }

        int t = in.nextInt();
        while (t-- > 0) {
            String n = in.nextInt() + "";
            int m = in.nextInt();

            long ans = 0;
            for (int i = 0; i < n.length(); i++) {
                ans = (ans + dp[m][n.charAt(i)-'0'])%MOD;
            }
            out.println(ans);

        }
    }
}
