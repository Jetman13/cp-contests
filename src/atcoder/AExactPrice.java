package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AExactPrice {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int y = in.nextInt();
        if (y == 0) {
            out.println("No");
            return;
        }
        out.println(y%100==0? "Yes":"No");
    }
}
