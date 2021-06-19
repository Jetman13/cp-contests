package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ADeterminant {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextInt();
        long b = in.nextInt();
        long c = in.nextInt();
        long d = in.nextInt();
        out.println((a*d) - (b*c));
    }
}
