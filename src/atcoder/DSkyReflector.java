package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DSkyReflector {
    long MOD = 998244353L;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        if (n == 1) {
            out.println(binpow(k,m,MOD));
            return ;
        }
        if (m == 1) {
            out.println(binpow(k,n,MOD));
            return ;
        }

        long ans = 0;
        for (int i = 1; i <= k ; i++) {
            long l = (binpow(i,n,MOD) + MOD - binpow(i-1,n,MOD))%MOD;
            long r = binpow(k-i+1,m,MOD);
            ans = (ans + (l*r)%MOD)%MOD;
        }
        out.println(ans);

    }

    long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) > 0) res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
}
