package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AReLU {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long x = in.nextLong();
        if (x >= 0) {
            out.println(x);
        } else {
            out.println(0);
        }
    }
}
