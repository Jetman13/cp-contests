package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CBouncingBall {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int p = in.nextInt();
            int k = in.nextInt();
            String s = in.nextLine();
            int x = in.nextInt();
            int y = in.nextInt();

            int[] dp = new int[n+1];
            for (int i = 0; i < k; i++) {
                dp[i] = s.charAt(i)-'0';
                for (int j = 1; i+j*k< n; j++) {
                    dp[i+j*k] = dp[i+j*k-k] + s.charAt(i+j*k) - '0';
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int yn = 0; yn < n; yn++) {
                int tmp = (n - yn - p +1)/k;
                if ((n-yn-p+1)%k == 0) {
                    tmp--;
                }
                if (yn+p-1 >= n) break;
                int xn = dp[yn+p-1+tmp*k] - dp[yn+p-1] + s.charAt(yn+p-1)-'0';
                int real = tmp + 1;
                ans = Math.min(ans,yn*y + (real-xn)*x);
            }
            out.println(ans);

        }
    }
}
