package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ATravelToBertown {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                if (l <= k && r >= k) {
                    ans = Math.max(ans,r-k+1);
                }
            }
            out.println(ans);
        }
    }
}
