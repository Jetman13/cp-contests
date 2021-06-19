package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class B200thABC200 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        for (int i = 0; i < k; i++) {
            if (n%200 == 0) {
                n/=200;
            } else {
                n = Long.valueOf(n + "200");
            }
        }
        out.println(n);
    }
}
