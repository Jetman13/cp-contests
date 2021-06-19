package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AHealthMDeath {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long m = in.nextLong();
        long h = in.nextLong();
        out.println(h%m == 0 ? "Yes":"No");
    }
}
