package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AIScream {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        int c = a + b;
        if (c >= 15 && b >= 8) {
            out.println(1);
        } else if (c >= 10 && b >= 3) {
            out.println(2);
        } else if (c >= 3 ) {
            out.println(3);
        } else {
            out.println(4);
        }
    }
}
