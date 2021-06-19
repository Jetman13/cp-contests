package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class InterestingXOR {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long c = in.nextLong();
            int i = 0;
            while ((1L<<i) <= c) i++;
            long tmp = (1L<<(i-1)) - 1;
            out.println((c^tmp) * tmp);
        }
    }
}
