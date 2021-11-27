package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class BSavings {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long l = 1;
        long r = n;
        if (n == 1) {
            out.println(1);
            return ;
        }
        long ans = 0;
        while (l <= r) {
            long mid = (l+r)/2;
            long tmp = mid*(mid+1)/2;
            if (tmp >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        out.println(ans);
    }
}
