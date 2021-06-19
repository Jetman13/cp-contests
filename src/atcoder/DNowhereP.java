package atcoder;

import tool.CommonUtils;
import tool.FastReader;
import java.io.PrintWriter;

public class DNowhereP {
    long MOD = (long)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long n = in.nextLong();
        long p = in.nextLong();

        out.println(CommonUtils.binpow(p-2,n-1,MOD)*(p-1)%MOD);
    }
}
