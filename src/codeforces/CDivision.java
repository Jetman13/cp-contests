package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CDivision {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long p = in.nextLong();
            long q = in.nextLong();
            if (p % q != 0) {
                out.println(p);
                continue;
            }

            long ans = 1;
            for (long i = 1; i*i <= q; i++) {
                if (q%i == 0) {
                    ans = Math.max(ans,cal(p,q,i));
                    ans = Math.max(ans,cal(p,q,q/i));
                }
            }
            out.println(ans);

        }
    }

    private long cal(long p, long q, long k) {
        if (k == 1) return 1;
        while (p%q == 0) {
            p/=k;
        }
        if (p%q == 0) return 1;
        return p;
    }
}
