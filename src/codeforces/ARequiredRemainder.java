package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ARequiredRemainder {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int n = in.nextInt() - y;
            out.println((n/x) * x + y);
        }
    }
}
