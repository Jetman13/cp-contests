package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class DJohnAndPizza {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long m = in.nextLong();
        long ans = (2*m-1)*n;

        out.println(Math.max((2*m-1)*n,(2*n-1)*m));
    }
}
