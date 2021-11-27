package atcoder;

import tool.CommonUtils;
import tool.FastReader;
import java.io.PrintWriter;

public class EIntegerSequenceFair {
    long MOD = 998244353;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        long m = in.nextLong();

        long ans = CommonUtils.binpow(k,n,MOD);
        out.println(CommonUtils.binpow(m,ans,MOD));
    }
}
