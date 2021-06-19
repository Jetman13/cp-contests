package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class CUnexpressed {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();

        if (n < 4) {
            out.println(n);
            return ;
        }
        boolean[] flag = new boolean[100002];
        long ans = 0;
        for (long i = 2; i*i <= n ; i++) {
            long tmp = i*i;
            if (tmp < flag.length && flag[(int)tmp]) continue;
            if (i < flag.length && flag[(int)i]) continue;
            while (tmp <= n) {
                if (tmp < flag.length) flag[(int)tmp] = true;
                ans++;
                tmp*=i;
            }
        }
        out.println(n-ans);
    }
}
