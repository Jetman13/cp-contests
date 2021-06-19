package nowcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class Happy {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long n = in.nextLong();

        long ans = 0;
        long index = 0;
        while (n > 0) {
            n/=2;
            index++;
        }
        out.println((1L<<index)-1);
    }
}
