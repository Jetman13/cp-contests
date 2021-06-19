package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DKnapsack1 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int w = in.nextInt();
        int[][] items = new int[n][2];
        in.readArr(items);

        long[] dp = new long[w+1];

        for (int i = 1; i <= n; i++) {
            for (int j = w; j >= 1 ; j--) {
                //装
                if (items[i-1][0] <= (long)j) {
                    dp[j] = Math.max(dp[j],dp[j-items[i-1][0]] + items[i-1][1]);
                }
                //不装
                dp[j] = Math.max(dp[j],dp[j]);
            }
        }
        out.println(dp[w]);

    }
}
