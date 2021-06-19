package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class EPassword {
    long MOD = (long)1e9 + 7L;
    long[][] dp;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        dpinit();

        while (t-- > 0) {

            int n = in.nextInt();
            String s = in.nextLine();
            boolean ansb = true;
            int pre = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '-') continue;
                int k = s.charAt(i) - '0';
                if (k < pre) {
                    ansb = false;
                    break;
                }
                pre = k;
            }
            if (!ansb) {
                out.println(0);
                continue;
            }
//            if (n == 1) {
//                out.println(9);
//                continue;
//            }

            int preIndex = s.charAt(0) == '-' ? -1 : 0;
            s += "9";
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i) != '-' && s.charAt(i-1) == '-') {
                    int num = i - preIndex - 1;
                    int q = (s.charAt(i) - '0') - (preIndex == -1 ? 1 : s.charAt(preIndex)-'0') + 1;
                    ans = (ans*cal(num,q))%MOD;
                }
                if (s.charAt(i) != '-') {
                    preIndex = i;
                }
            }

            out.println(ans);

        }
    }

    private long cal(int num, int q) {
        long sum = 0;
        for (int i = 1; i <= q ; i++) {
            sum = (sum+dp[num][i])%MOD;
        }
        return sum;
    }

    private void dpinit() {
        dp = new long[100002][11];

        dp[0][1] = 1;
        for (int i = 1; i < 100002; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k])%MOD;
                }
            }
        }
    }
}
