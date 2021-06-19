package codeforces;

import tool.FastReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BFairDivision {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            if (n%3 == 0) {
                out.println((n/3-1) + " " + n/3 + " " + (n/3+1));
            } else {
                out.println("-1");
            }
        }
    }
}
