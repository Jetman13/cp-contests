package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.BitSet;

public class EKPeriodicGarland {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            String s = in.nextLine();

            int[] rnum = new int[n+1];
            int p = -1;
            boolean f = true;
            for (int i = n-1; i >=0 ; i--) {
                rnum[i] = rnum[i+1] + s.charAt(i)-'0';
                if (s.charAt(i) == '1') {
                    if (p != -1 && p - i != k) {
                        f = false;
                    }
                    p = i;
                }
            }
            if (f) {
                out.println(0);
                continue;
            }
            int ans = Math.max(rnum[0]-1,0);
            int[] dp = new int[n+1];

            for (int i = 0; i < n; i++) {
                dp[i] = rnum[0] - rnum[i] + (s.charAt(i) == '1' ? 0 : 1);
                if (i - k >= 0) {
                    dp[i] = Math.min(dp[i],dp[i-k] + rnum[i-k+1] - rnum[i] + (s.charAt(i) == '1' ? 0 : 1));
                }
                ans = Math.min(ans,dp[i]+rnum[i+1]);
            }

            out.println(ans);

        }
    }
}
