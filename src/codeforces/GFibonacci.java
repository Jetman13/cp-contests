package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class GFibonacci {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        long n = in.nextLong();
        long sum = n*(n-1)/2;
        long one = (n/3)*2 + n%3;
        out.println(sum - one*(one-1)/2);
    }
}
