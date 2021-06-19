package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class ACandiesAndTwoSisters {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            out.println(n/2 + ((n%2 == 0)?-1:0));
        }
    }
}
