package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class EKnapsack2 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int w = in.nextInt();
        int[][] items = new int[n][2];
        in.readArr(items);

        long[] dp = new long[100003];
        Arrays.fill(dp,(long)1e18);
        dp[0] = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 100000; j >= 0; j--) {
                if (j >= items[i][1]) {
                    dp[j] = Math.min(dp[j-items[i][1]]+items[i][0],dp[j]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 100000 ; i++) {
            if (dp[i] <= w) {
                ans = Math.max(ans,i);
            }
        }
        out.println(ans);


    }
}
