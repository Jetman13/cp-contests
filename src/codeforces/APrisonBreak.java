package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class APrisonBreak {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            int ans = dis(1,1,r,c);
            ans = Math.max(ans,dis(1,m,r,c));
            ans = Math.max(ans,dis(n,1,r,c));
            ans = Math.max(ans,dis(n,m,r,c));
            out.println(ans);
        }
    }

    private int dis(int i, int i1, int r, int c) {
        return Math.abs(i-r) + Math.abs(i1-c);
    }
}
