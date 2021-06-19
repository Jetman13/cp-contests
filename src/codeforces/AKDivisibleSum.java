package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AKDivisibleSum {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();
            if (k < n) {
                long tmp = n/k;
                if (n%k!=0) {
                    tmp = n/k + 1;
                }
                k*=tmp;
            }
            out.println((long)Math.ceil(k/(n*1.0)));
        }
    }
}
