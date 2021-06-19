package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BPlaySnuke {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long a = in.nextLong();
            long p = in.nextLong();
            long x = in.nextLong();

            if (x-a > 0) {
                ans = Math.min(ans,p);
            }
        }
        out.println(ans == Long.MAX_VALUE ? -1:ans);

    }
}
