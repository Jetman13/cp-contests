package google;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Matrygons {
    int[] dp;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        if (testNumber == 1) {
            dp = new int[1000002];
            dp[1] = 1;
            dfs(1,1,1);
        }

        int sum = in.nextInt();
        int ans = 1;
        for (int i = 3; i <= sum; i++) {
            if (sum%i==0) {
                ans = Math.max(ans,dp[sum/i]);
            }
        }
        out.println("Case #" + testNumber + ": " + ans);

    }

    private void dfs(int k, int sum, int num) {
        for (int i = 1; i <= 1000000 ; i++) {
            for (int j = i*2+1; j <= 1000000 ; j+=i) {
                dp[j] = Math.max(dp[j],dp[i]+1);
            }
        }
    }
}
