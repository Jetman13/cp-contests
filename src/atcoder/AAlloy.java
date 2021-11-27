package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AAlloy {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        if (a > 0 && b == 0) {
            out.println("Gold");
        } else if (a == 0 && b > 0) {
            out.println("Silver");
        } else {
            out.println("Alloy");
        }

    }
}
