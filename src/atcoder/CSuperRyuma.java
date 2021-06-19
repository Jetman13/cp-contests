package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CSuperRyuma {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long r1 = in.nextLong();
        long c1 = in.nextLong();
        long r2 = in.nextLong();
        long c2 = in.nextLong();

        if (r1 > r2) {
            long tmpr = r1;
            long tmpc = c1;
            r1 = r2;
            c1 = c2;
            r2 = tmpr;
            c2 = tmpc;
        }

        if (c2 < c1) {
            c2 = 2*c1 - c2;
        }

        if (c1 == c2 && r1 == r2) {
            out.println(0);
            return ;
        }
        if (c1 + r1 == c2 + r2) {
            out.println(1);
            return ;
        }

        long tmp = r2 - r1;
        long ans = 1 + (Math.abs(c1+tmp - c2)-1)/3 + 1;
        out.println(ans);



    }
}
