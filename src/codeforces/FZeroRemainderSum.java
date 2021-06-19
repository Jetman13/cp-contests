package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FZeroRemainderSum {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i+1][j+1] = in.nextInt();
            }
        }

        int[][][][] dp = new int[n+2][m+1][m+1][k];
        for (int i = 0; i <= n+1 ; i++) {
            for (int j = 0; j <= m ; j++) {
                for (int l = 0; l <= m ; l++) {
                    Arrays.fill(dp[i][j][l],-1);
                }
            }
        }
        dp[1][0][0][0] = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                //int max = 0;
                for (int l = 0; l <= j ; l++) {
                    //if (l > m/2) continue;
                    for (int mod = 0; mod < k; mod++) {
                        dp[i][j][l][mod] = dp[i][j-1][l][mod];
                        int nmod = (mod + 70*k - a[i][j])%k;
                        if (l > 0 && dp[i][j-1][l-1][nmod] >= 0 && l <= m/2)
                            dp[i][j][l][mod] = Math.max(dp[i][j][l][mod],dp[i][j-1][l-1][nmod] + a[i][j]);

                        dp[i+1][0][0][mod] = Math.max(dp[i+1][0][0][mod],dp[i][j][l][mod]);

                    }
                }
            }
        }
        out.println(dp[n+1][0][0][0]);

    }
}
