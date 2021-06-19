package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AMostUnstableArray {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve(in,out);
        }
    }

    private void solve(FastReader in, PrintWriter out) {

        long n = in.nextInt();
        long m = in.nextInt();


        if (n == 1) {
            out.println(0);
        } else if (n == 2) {
            out.println(m);
        } else {
            out.println(m*2);
        }
    }
}
