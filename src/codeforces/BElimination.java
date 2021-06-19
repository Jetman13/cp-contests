package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BElimination {
    public void solve(int testNumber, FastReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt() + in.nextInt();
            int b = in.nextInt() + in.nextInt();
            out.println(Math.max(a,b));
        }
    }
}
