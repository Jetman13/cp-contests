package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CComma {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long[] a = new long[10];
        a[0] = 1000L;
        a[1] = 1000000L;
        a[2] = 1000000000L;
        a[3] = 1000000000000L;
        a[4] = 1000000000000000L;

        long ans = 0;
        for (int i = 4; i >= 0 ; i--) {
            if (a[i] > n) continue;

            ans += (n-a[i]+1)*(i+1);
            n = a[i]-1;
        }
        out.println(ans);
    }
}
