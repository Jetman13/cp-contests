package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CUniqueNumber {
        long[][] dp = new long[51][11];
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long ans = -1;
            for (int i = 1; i < 10; i++) {
                if (work(n,i) > 0) {
                    ans = work(n,i);
                    break;
                }
            }
            out.println(ans);
        }
    }

    private long work(int n, int bit) {
        if (bit <= 0 || n <= 0) return -1;
        if (dp[n][bit] != 0) return dp[n][bit];
        if (n < 10 && bit == 1) return dp[n][bit] = n;
        for (int i = 1; i < 10; i++) {
            long tmp = work(n-i,bit-1);
            if (tmp > 0 && check(tmp,i)) {
                return dp[n][bit] = Long.parseLong(i + "" + work(n-i,bit-1));
            }
        }
        return dp[n][bit] = -1;
    }

    private boolean check(long tmp, int i) {
        boolean f = true;
        while (tmp > 0) {
            long b = tmp%10;
            if (b == i) return false;
            tmp/=10;

        }
        return true;
    }
}
