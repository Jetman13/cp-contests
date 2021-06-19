package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AXORwice {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long ans = 0;
            out.println(a^b);

        }
    }
}
