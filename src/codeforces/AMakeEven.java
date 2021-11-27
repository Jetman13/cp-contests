package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class AMakeEven {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            if (n % 2 == 0) {
                out.println(0);
            } else {
                String str = String.valueOf(n);
                int even = -1;
                for (int i = 0; i < str.length(); i++) {
                    if ((str.charAt(i)-'0')%2==0) {
                        even = i;
                        break;
                    }
                }
                if (even == -1) {
                    out.println(-1);
                } else {
                    if (even == 0) {
                        out.println(1);
                    } else {
                        out.println(2);
                    }
                }
            }
        }
    }
}
