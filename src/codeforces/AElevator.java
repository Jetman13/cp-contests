package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AElevator {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            out.println(Math.min((x-1)*20,(x+y-2)*5));
        }
    }
}
