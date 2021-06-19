package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AChinchirorin {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a == b) {
            out.println(c);
        } else if (a == c) {
            out.println(b);
        } else if (b == c) {
            out.println(a);
        } else {
            out.println(0);
        }
    }
}
