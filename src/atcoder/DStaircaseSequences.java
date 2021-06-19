package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class DStaircaseSequences {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();

        long ans = 0;
        for (long i = 1;; i++) {
            long tmp = n - (i*i + i)/2;
            if (tmp < 0) break;

                if (tmp%i == 0) ans+=2;

        }
        out.println(ans);

    }
}
