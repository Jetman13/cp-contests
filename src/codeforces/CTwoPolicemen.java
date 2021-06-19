package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CTwoPolicemen {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            int ans = Math.max(n-x,y-1);

            for (int i = x; i < y; i++) {
                int tx = Math.min((i-x)*2+x-1,(x-1)*2+(i-x));
                int ty = Math.min((n-y)*2+y-i-1,(y-i-1)*2+(n-y));
                ans = Math.min(ans,Math.max(tx,ty));
            }
            out.println(ans);

        }
    }
}
