package facebook;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class A2WeakTypingChapter2 {
    long MOD = 1000000007;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = in.nextInt();
            String str = in.nextLine();

            long[][] dp = new long[n+1][2];

            long ans = 0;
            int pre = -1;
            for (int i = 1; i <= n ; i++) {
                char ch = str.charAt(i-1);
                if (ch == 'F') {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                } else {
                    int p = (ch == 'X') ? 1 : 0;
                    if (pre == -1) {
                        pre = i-1;
                    } else {
                        if (str.charAt(pre) == ch) {
                            dp[i][p] = dp[pre+1][p];
                        } else {
                            dp[i][p] = (dp[pre+1][p^1] + pre+1) % MOD;
                        }
                        pre = i-1;
                    }
                }
                ans = (ans + dp[i][0] + dp[i][1])%MOD;
            }


            out.println("Case #" + test + ": " + ans);


        }
    }

    private long cal(int n) {
        long num = n;
        return (num + num*(num-1)/2)%MOD;
    }
}
