package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class NWasteSorting {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long c1 = in.nextLong();
            long c2 = in.nextLong();
            long c3 = in.nextLong();

            long[] a = new long[5];
            for (int i = 0; i < 5; i++) {
                a[i] = in.nextLong();
            }

            c1 -= a[0];
            c2 -= a[1];
            c3 -= a[2];

            if (c1 < 0 || c2 < 0 || c3 < 0) {
                out.println("NO");
                continue;
            }
            long mintmp = Math.min(c1,a[3]);
            a[3]-=mintmp;
            c1 = c1 - mintmp;
            mintmp = Math.min(c2,a[4]);
            a[4]-=mintmp;
            c2 = c2 - mintmp;
            if (c1 < 0 || c2 < 0 || c3 < 0) {
                out.println("NO");
                continue;
            }
            out.println(c3 >= a[3] + a[4] ? "YES":"NO");


        }
    }
}
