package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AABC {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long k = in.nextLong();
        long[] tow = new long[200003];
        long ans = 0;
        for (long i = 1; i <= k; i++) {
            for (long j = 1; j <= k ; j++) {
                if (i*j > k) break;
                ans += k/(i*j);
            }
        }
        out.println(ans);
    }
}
