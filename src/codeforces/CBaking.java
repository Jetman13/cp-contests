package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CBaking {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t0 = in.nextInt();
            int t1 = in.nextInt();
            int t2 = in.nextInt();

            int l = Math.min(t1,t2);
            int r = Math.max(t1,t2);

            if (l >= t0) {
                out.println(r-t0);
            } else if (r <= t0) {
                out.println(t0 - l);
            } else {
                out.println(r-l + Math.min(t0-l,r-t0));
            }
    }
}
