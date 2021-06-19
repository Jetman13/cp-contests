package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class GShortTask {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int[] dp = new int[10000003];
        dp[1] = 1;
        for (int i = 2; i < 10000001; i++) {
            int sum = 0;
            for (int j = 1; j*j <= i; j++) {
                if (i%j==0) {
                    if (i/j == j) {
                        sum += j;
                    } else {
                        sum += j + i / j;
                    }
                }
                if (sum > 10000000) break;
            }
            if (sum <= 10000000 && dp[sum]==0) {
                dp[sum] = i;
            }
        }
        int t = in.nextInt();
        while (t-- > 0) {
            int c = in.nextInt();
            out.println(dp[c] == 0 ? -1 : dp[c]);
        }
    }
}
