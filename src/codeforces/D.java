package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long ans = 0;
        long[] a = new long[n];
        in.readArr(a);

        for (int i = 1; i < n; i++) {
            ans += Math.max(a[i],a[i-1]);
        }
        out.println(ans);
    }
}
