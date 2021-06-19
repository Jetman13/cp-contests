package codechef;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddingSquares {
    int size = (int)1e9;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
//        int w = in.nextInt();
//        int h = in.nextInt();
//        int n = in.nextInt();
//        int m = in.nextInt();
        int k = in.nextInt();
        String s = in.nextLine();
        List<Integer> list = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        out.println(maxProfit(k,list.toArray(new Integer[list.size()])));

    }
    public int maxProfit(int k, Integer[] prices) {
        int n = prices.length;
        if (n <= 1 || k <= 0) return 0;
        k = k > n/2 ? (n/2) : k;
        int[][][] dp = new int[n+1][k+1][2];
        dp[1][1][1] = -prices[0];
        dp[1][0][0] = 0;

        for (int i = 0; i <= k; i++) {
            dp[1][i][1] = -prices[0];
        }

        for (int i=2;i<=n;i++) {
            for (int j=1;j<=k;j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i-1]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i-1]);
            }
        }
        return dp[n][k][0];

    }
}
