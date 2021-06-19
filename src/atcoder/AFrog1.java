package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AFrog1 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        in.readArr(a);
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (i-j-2 >= 0)
                dp[i] = Math.min(dp[i],dp[i-j-1] + Math.abs(a[i-1] - a[i-j-2]));
            }
        }
        out.println(dp[n]);
    }
}
