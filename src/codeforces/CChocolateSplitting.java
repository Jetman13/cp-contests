package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CChocolateSplitting {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long m = in.nextLong();
            long p = in.nextLong();

            if (n*m < p) {
                out.println("NO");
                continue;
            }

            boolean ans = false;
            for (long i = 1; i*i <= p ; i++) {
                if (p%i == 0 && check(i,p/i,n,m)) {
                    ans = true;
                    break;
                }
            }
            out.println(ans?"YES":"NO");

        }
    }

    private boolean check(long a, long b, long n, long m) {
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        if (n > m) {
            long tmp = n;
            n = m;
            m = tmp;
        }
        return a <= n && b <= m;
    }
}
