package nowcoder;

import tool.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class CCABak {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.nextLine();

        int len = s.length();
        String tmp = "NowCoder";
        int tlen = tmp.length();
        if (len < tmp.length()) {
            out.println(0);
            return ;
        }
        long ans = 0;

        int[][] dp = new int[len+2][10];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        if (s.charAt(0) == tmp.charAt(0)) dp[1][1] = 1;
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j <= tlen; j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == tmp.charAt(j-1) && dp[i-1][j-1] >= 0) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (s.charAt(i-1) == tmp.charAt(j-1) && j==1) {
                    dp[i][j] = i;
                }
            }
            if (dp[i][tlen] >= 0) {
                ans += dp[i][tlen];
            }

        }


        out.println(ans);

    }


}
