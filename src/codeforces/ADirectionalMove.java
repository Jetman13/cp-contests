package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class ADirectionalMove {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.nextLine();
            int one = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') one++;
            }
            int zero = n - one;

            one %=4;
            zero %=4;

            one = (one + 4 - zero)%4;
            if (one == 0) {
                out.println("E");
            } else if (one == 1) {
                out.println("N");
            } else if (one == 2) {
                out.println("W");
            } else {
                out.println("S");
            }
        }
    }
}
