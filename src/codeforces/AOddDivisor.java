package codeforces;

import tool.FastReader;
import tool.Primes;

import java.io.PrintWriter;

public class AOddDivisor {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();

            while (n%2==0) {
                n/=2;
            }

            if (n == 1) {
                out.println("NO");
                continue;
            }

            out.println("YES");
        }
    }
}
