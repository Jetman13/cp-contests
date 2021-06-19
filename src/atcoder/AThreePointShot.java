package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AThreePointShot {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long x = in.nextLong();
        long y = in.nextLong();
        long min = Math.min(x,y);
        long max = Math.max(x,y);

        out.println((min + 3 > max)?"Yes":"No");
    }
}
