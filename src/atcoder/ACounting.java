package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ACounting {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        out.println(b >= a ? b - a + 1 : 0);
    }
}
