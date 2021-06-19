package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BBadBoy {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            long n = in.nextInt();
            long m = in.nextInt();
            long i = in.nextInt();
            long j = in.nextInt();

            if (i != 1 || j != 1) {
                out.println("1 1 "+n + " "+m);
            } else {
                out.println("1 " + m + " " + n + " 1");
            }

        }
    }
}
