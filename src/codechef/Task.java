package codechef;

import tool.FastReader;
import java.io.PrintWriter;

public class Task {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        long[] a = new long[]{0,20,36,51,60};
        while (t-->0) {
            long n = in.nextLong();
            if (n < 4) {
                out.println(a[(int)n]);
                continue;
            }
            long tmp = n%4L;
            out.println((n/4L)*11L*4L + (4-tmp)*4L  + a[(int)tmp]);
        }
    }
}
