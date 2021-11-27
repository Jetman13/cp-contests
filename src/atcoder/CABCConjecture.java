package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CABCConjecture {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long ans = 0;
        for (long a = 1; a*a*a <= n ; a++) {
            for (long b = a; a*b*b <= n ; b++) {
                ans += n/(a*b) - b + 1;
            }
        }
        out.println(ans);
    }
}
