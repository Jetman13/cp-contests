package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ELucky7Battle {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.nextLine();
        String x = in.nextLine();

        boolean[][] dp = new boolean[n+1][8];

        dp[n][0] = true;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                int sint = s.charAt(i) - '0';
                if (x.charAt(i) == 'T') {
                    if (dp[i+1][(j*10)%7] || dp[i+1][(j*10+sint)%7]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i+1][(j*10)%7] && dp[i+1][(j*10+sint)%7]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        out.println(dp[0][0] ? "Takahashi":"Aoki");

    }
}
