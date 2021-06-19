package nowcoder;

import tool.FastReader;
import tool.Primes;

import java.io.PrintWriter;

public class GCD {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long n = in.nextLong();

        Primes p = new Primes((int)n);

        int ans = p.count().size() + 1;
        out.println(ans >= n ? "-1" : ans+1);

    }
}
