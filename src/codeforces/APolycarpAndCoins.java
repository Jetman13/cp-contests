package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class APolycarpAndCoins {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long n = in.nextLong();
            long k = n%3;
            if (k == 0) {
                out.println(n/3 + " " + n/3);
            } else if (k == 1) {
                out.println((n/3 + 1) + " " + (n/3));
            } else {
                out.println((n/3) + " " + (n/3 + 1));
            }
        }
    }
}
