package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AFromZeroToY {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long x = in.nextLong();
            long y = in.nextLong();
            int ans = 0;
            while (y != 0) {
                long tmp = x;
                while (tmp*10 <= y) {
                    tmp*=10;
                }
                if (tmp > y) {
                    ans+=y;
                    break;
                }
                y-=tmp;
                ans++;
            }
            out.println(ans);
        }
    }
}
