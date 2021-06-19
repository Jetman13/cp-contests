package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CBoardMoves {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        long[] ans = new long[1000000];
        for (int i = 3; i < 500000; i+=2) {
            ans[i] = ans[i-2] + (i*4L-4)*((long)i/2);
        }
        while (t-->0) {
            int n = in.nextInt();
            out.println(ans[n]);

        }
    }
}
