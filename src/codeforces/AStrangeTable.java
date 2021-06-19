package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AStrangeTable {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long m = in.nextLong();
            long x = in.nextLong();
            long l = (x-1)/n;
            long r = (x-1)%n;
            out.println((r)*m + l+1);
        }
    }
}
