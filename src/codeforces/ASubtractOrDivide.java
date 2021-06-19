package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ASubtractOrDivide {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            if (n == 1) {
                out.println(0);
                continue;
            }
            if (n == 2) {
                out.println(1);
                continue;
            }
            if (n == 3) {
                out.println(2);
                continue;
            }
            if (n%2 == 0) {
                out.println(2);
            } else {
                out.println(3);
            }
        }
    }
}
