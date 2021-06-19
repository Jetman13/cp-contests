package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CUnstableString {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t--> 0) {
            String s = in.nextLine();
            int len = s.length();
            long[][] dp = new long[len+3][2];
            long ans = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '?') {
                    dp[i+1][0] = dp[i][1]+1;
                    dp[i+1][1] = dp[i][0]+1;
                    ans += Math.max(dp[i+1][0],dp[i+1][1]);
                } else {
                    int bit = s.charAt(i) - '0';
                    dp[i+1][bit] = dp[i][1^bit] + 1;
                    ans += dp[i+1][bit];
                }
            }
            out.println(ans);
        }
    }
}
