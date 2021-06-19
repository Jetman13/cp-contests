package atcoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class BLog {
    long max = (long)1e9;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long ans = n;
        long l = 0;
        long r = n+1;
        while (l <= r) {
            long mid = (l+r)/2;
            BigDecimal bd = new BigDecimal(mid).multiply(new BigDecimal(mid-1));
            BigDecimal bd2 = new BigDecimal(2L*(n+1L));
            if (bd.compareTo(bd2) > 0) {
                r = mid - 1;
            } else {
                ans = Math.min(ans,n-mid+2);
                l = mid + 1;
            }
        }
        out.println(ans);
    }
}
