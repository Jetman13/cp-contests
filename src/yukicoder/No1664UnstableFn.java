package yukicoder;

import tool.FastReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public class No1664UnstableFn {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long ans = n;
        long tmp = toLong((Math.sqrt(n)));
        ans = Math.min(ans,tmp + 2 + (n - tmp*tmp));
        for (long i = 2; i*i*i <= n; i++) {
            long k = toLong((Math.log(n)/Math.log(i)));
            if (Math.pow(i,k) > n) {
                out.println(i + " " + k);
            }
            ans = Math.min(ans,i + k + (n - toLong(Math.pow(i,k))));

        }
        out.println(ans);
    }

    private long toLong(double sqrt) {
        long tmp = (long)sqrt;
//        if (Math.abs(tmp + 1.0 - sqrt) < 0.00000001) return tmp + 1;
        if (tmp + 1.0 > sqrt) {
            tmp++;
        }
        if (tmp + 1.0 <= sqrt) return tmp + 1;
        return tmp;
    }
}
