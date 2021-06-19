package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class CPingPong {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            out.println((x-1) + " " + y);
        }
    }
}
