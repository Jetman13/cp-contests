package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FDecreasingHeights {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve(in,out);
        }
    }

    private void solve(FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[][] grid = new long[n+2][m+2];
        for (int i = 0; i < n+2; i++) {
            Arrays.fill(grid[i],-1);
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = in.nextLong();
            }
        }

        grid[0][1] = 0;
        grid[1][0] = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long tmp = grid[1][1];
                grid[1][1] = grid[i][j] - i - j + 1 + 1;
                if (tmp < grid[1][1])  {
                    grid[1][1] = tmp;
                    continue;
                }
                long w = work(grid);
                if (w != -1) {
                    ans = Math.min(ans, w + tmp - grid[1][1]);
                }
                grid[1][1] = tmp;
            }
        }
        out.println(ans);
    }

    private long work(long[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] dp = new long[n][m];
        dp[1][1] = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                long b = grid[1][1] + i + j - 2;
                if (b > grid[i][j] || (dp[i-1][j] == -1 && dp[i][j-1] == -1)) {
                    dp[i][j] = -1;
                    continue;
                }
                dp[i][j] = Long.MAX_VALUE;
                if (dp[i-1][j] != -1) {
                    dp[i][j] = dp[i-1][j] + grid[i][j] - b;
                }
                if (dp[i][j-1] != -1) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + grid[i][j] - b);
                }
            }
        }
        return dp[n-2][m-2];
    }
}
