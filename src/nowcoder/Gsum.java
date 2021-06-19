package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Gsum {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        out.println(n + n*(n+1)/2);
    }
}
