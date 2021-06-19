package atcoder;

import tool.FastReader;
import java.io.PrintWriter;

public class AVeryVeryPrimitiveGame {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (c == 0) {
            out.println(a > b ? "Takahashi":"Aoki");
        } else {
            out.println(a > (b-1) ? "Takahashi" : "Aoki");
        }

    }
}
