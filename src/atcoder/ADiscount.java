package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ADiscount {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        out.println((a-b)/(double)a * 100.0);
    }
}
