package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DSquares {
    long MOD = (long)1e9 + 7;
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long ans = (((((n-a+1)*(n-a+1))%MOD) * (((n-b+1)*(n-b+1))%MOD)%MOD))%MOD;
            long blank = 0L;
            if (n-a-b >= 0) {
                blank = (n-a-b+2)*(n-a-b+1);
            }
            long tmp = (n-a+1)*(n-b+1) - blank;
            tmp%=MOD;
            tmp = (tmp*tmp)%MOD;
            out.println((ans+MOD-tmp)%MOD);
        }
    }
}
