package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ATwiblr {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        long tmp = a*2 + 100 - b;

        out.println(tmp >= 0 ? tmp : 0);
    }
}
