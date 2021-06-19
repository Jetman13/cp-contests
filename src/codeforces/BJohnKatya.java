package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BJohnKatya {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        if (n == 1) {
            out.println("Win");
        } else if (n == 2) {
            out.println("Draw");
        } else {
            out.println("Lose");
        }
    }
}
