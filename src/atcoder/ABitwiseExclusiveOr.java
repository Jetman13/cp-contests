package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ABitwiseExclusiveOr {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        
        int a = in.nextInt();
        int b = in.nextInt();
        int i = 0;
        for (i = 0; i <= 255; i++) {
            if ((a^i) == b) {
                break;
            }
        }
        out.println(i);
    }
}
