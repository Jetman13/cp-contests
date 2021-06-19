package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DWandering {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        long[] s = new long[n+1];
        long[] max = new long[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + a[i];
            max[i+1] = Math.max(max[i],s[i+1]);
        }
        long ans = 0;
        long tmp = 0;
        for (int i = 1; i <= n; i++) {
            if (max[i] + tmp > ans) {
                ans = max[i] + tmp;
            }
            tmp += s[i];
        }
        out.println(ans);


    }
}
