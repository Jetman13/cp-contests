package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AArithmetic {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (a*b == c) {
                out.println("YES");
                out.println(a + " " + b + " " + c);
            } else if (a*c == b) {
                out.println("YES");
                out.println(a + " " + c + " " + b);
            } else if (b*c == a) {
                out.println("YES");
                out.println(b + " " + c + " " + a);
            } else {
                out.println("NO");
            }
        }
    }
}
