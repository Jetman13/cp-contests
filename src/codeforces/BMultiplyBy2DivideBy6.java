package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class BMultiplyBy2DivideBy6 {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            if (n == 1) {
                out.println(0);
                continue;
            }
            int num = 0;
            while (n > 1) {
                if (n%6 == 0) {
                    n/=6;
                } else if (n%3 == 0) {
                    n*=2;
                } else {
                    num = 0;
                    break;
                }
                num++;
            }
            out.println(num == 0 ? -1 : num);
        }
    }
}
