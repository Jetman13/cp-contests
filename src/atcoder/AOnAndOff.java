package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AOnAndOff {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int s = in.nextInt();
        int t = in.nextInt();
        int x = in.nextInt();
        if (s < t) {
            out.println((x >= s && x < t) ? "Yes" : "No");
        } else {
            out.println((x >= s || x < t) ? "Yes" : "No");
        }
    }
}
