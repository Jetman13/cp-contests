package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class ADiv {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();

        if (n < 2) {
            out.println(0);
            return ;
        }

        out.println(n-1);

    }
}
