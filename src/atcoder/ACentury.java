package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ACentury {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        if (n%100 == 0) {
            out.println((n)/100);
        } else {
            out.println((n+100) / 100);
        }
    }
}
