package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class GGCD {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] dp = new long[n+1];
        //dp[1] = 1%k==0 ? 1 : 0;
        for (int i = 1; i <= n ; i++) {
            dp[i] = dp[i-1] + ((i%k)==0?i:0);
        }
        out.println(Arrays.stream(dp).sum());
    }
}
