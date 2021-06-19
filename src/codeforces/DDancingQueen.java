package codeforces;

import tool.FastReader;
import java.io.PrintWriter;

public class DDancingQueen {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();

        StringBuilder sb = new StringBuilder();
        while (n >= 4) {
            sb.append("ABBA");
            n-=4;
        }

        int ans = 0;
        if (n == 1) {
            sb.append("A");
            ans = 1;
        } else if (n == 2) {
            sb.append("AB");
            ans = 1;
        } else if (n == 3) {
            sb.append("BAA");
        }

        out.println(ans);
        out.println(sb.reverse().toString());


    }
}
